
$(document).ready(function() {
	window.GLOBALint = 0;
	var url = window.location.pathname;
	/*
		path's to not overload javascript functions
	*/
	switch(url) {
	  case '/Dealinzien.html':
	  	checklogin();
	  	loaddeal();
	  break;
	  case '/Homepage.html':
	  	checklogin();
		loaddeals("#dealtable");
		$('#dealtable tbody').on( 'click', 'tr', function () {
		   let id = $(this).attr('id');
			sessionStorage.setItem('dealid',id);
			window.location.href = "Dealinzien.html";
		} );
	  break;
	  case '/Dealregisteren.html':
	  	checklogin();
	  	
		addmaterial('#material_body');
	  break;
	  case '/admin.html':
	  	checklogin();
	  	loadusers('#users','#usersbody');
	  	$('.usereditbox').hide();
	  	$('#usersbody').on( 'click', 'tr', function () {
	  		console.log();
	  		let idarr 	= $(this).attr('id').split("_");
	  		let id 		= idarr[0];
	  		let email 	= $(this).find('.email').text();
	  		let rol 	= $(this).find('.rol').text();
	  		let vendor 	= $(this).find('.vendor').text();
	  		$('.usereditbox').show();
	  		$('#ids').val(id);
	  		$('#Email').val(email);
	  		$('#Rol').val(rol);
	  		$('#Vendor').val(vendor);
	  		$('#usereditbutton').show();
			$("#deleteitbutton").show();
			$("#useraddbutton").hide();
		} );
	  break;
	  default:
		  $(document).on('click', '#login_button', function(event) {
			event.preventDefault();
			login();

		});
	}
	
	
	
	
});

function showAddUserBox(){
	$('.usereditbox').show();
	$('#ids').val('');
	$('#Email').val('');
	$('#Rol').val('');
	$('#Vendor').val('');
	
	$('#usereditbutton').hide();
	$('#deleteitbutton').hide();
	$("#useraddbutton").show();

}
function updateuser(selector){
	 const element = document.getElementById(selector);
	 console.log(element);
     const formData      = new FormData(element);
     const encodeData    = new URLSearchParams(formData);
     fetch("api/users", {
	    method: 'PUT',
	    body: encodeData
	}).then(function(response) {
	    if(response.status == 200){
location.reload();
	        return response.text();
	    }else{
	        $.notify("Something went wrong");
	    }
	})
	    .then(function(myJson) {
	    	if(myJson){
	    		console.log("sss");
	    	}
	    });
}

function adduser(selector){
	 const element = document.getElementById(selector);
     const formData      = new FormData(element);
     const encodeData    = new URLSearchParams(formData);
     fetch("api/users", {
	    method: 'POST',
	    body: encodeData
	}).then(function(response) {
	    if(response.status == 200){
location.reload();
	        return response.text();
	    }else{
	        $.notify("Something went wrong");
	    }
	})
	    .then(function(myJson) {
	    	if(myJson){
	    		console.log("sss");
	    	}
	    });	
}
function checklogin(){
    let token = sessionStorage.getItem("token");
    if(token == "" || token == null){
    	// console.log();
        window.location.href = "index.html";
    }
}

function loadusers(selectorhead,selectorbody){
	$.getJSON('api/users', function(users, textStatus) {
			$.each(users, function(index, user) {
				let html = `<tr id="${user.id}_userline">
				<td class="email">${user.email}</td>
				<td class="rol" >${user.rol}</td>
				<td class="vendor">${user.vendor}</td>
				</tr>`;
				$(selectorbody).append(html);
			});
			$(selectorhead).DataTable();
	});
}
function deleteuser(selector){
	const element = document.getElementById(selector);
	console.log(element);
    const formData      = new FormData(element);
    const encodeData    = new URLSearchParams(formData);
    fetch("api/users", {
        method: 'DELETE',
        body: encodeData
    }).then(function(response) {
        if(response.status == 200){

            return response.text();
        }else{
            $.notify("Username or password is not correct");
        }
    })
        .then(function(myJson) {
            if(myJson){
                console.log("asd");
            }
        });
}
function loaddeal(){
	let id = sessionStorage.getItem("dealid");
	// console.log(id);
	$.getJSON(`api/Deal/${id}`,function(json, textStatus) {
			
			$('#id').val(json.id);
			$('#dealname').val(json.dealname);
			$('#one_time_benefit').val(json.one_time_benefit);
			$.each(json.DM, function(index, line) {
				let line_detail_td = `<td colspan="2">
					<table id="dealtable" class="table table-responsive">
						<thead>
							<th>Amount</th>
							<th>Type</th>
							<th>Receive date</th>
							<th>Customer</th>
							<th>Reseller discount</th>
						</thead>
						<tbody>
					`;
				$.each(line.mld, function(index, linedetail) {
					if(linedetail.type == 'send'){
						line_detail_td += `
						<tr>
							<td><input class="form-control" value="${linedetail.Amount}" type="text"></td>
							<td><input class="form-control" value="${linedetail.type}" type="text"></td>
							<td><input class="form-control" value="${linedetail.ship_date}" type="text"></td>
							<td><input class="form-control" value="${linedetail.customer}" type="text"></td>
							<td><input class="form-control" value="${linedetail.reseller_discount}" type="text"></td>
						</tr>`;
					}else{
						line_detail_td += `
						<tr>
							<td><input class="form-control" value="${linedetail.Amount}" type="text"></td>
							<td><input class="form-control" value="${linedetail.type}" type="text"></td>
							<td><input class="form-control" value="${linedetail.receive_date}" type="text"></td>
						</tr>`;
					}
				});	
				line_detail_td += `<input type="hidden" name="counter"/></tbody></table>`;
				let html = `
				<tr> 
					<td> <input class="form-control" value="${line.VPN}" type="text"></td>
					<td> <input class="form-control" value="${line.purchasing_price}" type="text"></td>
				</tr>${line_detail_td}
				`;

				$(`#material_body`).append(html);
			});

	});
}
function removeline(element){
	let rows = $('#material_body > tr');
	// console.log(rows.length);
	if(rows.length > 2){
		
			let idfull = $(element).parent().parent().attr('id');
			let id = idfull.split('_')[0];
			$(`#${id}_line`).remove();
			$(`#line_detail_${id}`).remove();
		
	}
}
function removesubline(element){
	$(element).parent().parent().remove();
}
function addmaterial(selector){
	let html = `
				<tr id="${window.GLOBALint}_line"> 
					<td> <input class="form-control"  placeholder="vpn" name="vpn" type="text"></td>
					<td> <input class="form-control"  placeholder="purchasing_price" name="purchasing_price" type="text"></td>
					<td> 
						<button  type="button" class="btn btn-primary" onclick="adddetail_line(${window.GLOBALint},'receive')">Add stock</button>
						<button  type="button" class="btn btn-primary" onclick="adddetail_line(${window.GLOBALint},'send')">Add sell</button>
						<button  type="button" class="btn btn-primary" onclick="removeline(this)">remove</button>
					</td>
				</tr>
				<tr id="line_detail_${window.GLOBALint}">
				<td colspan="3">
					<table>
						<thead>
							<th>Amount</th>
							<th>Type</th>
							<th>Receive date</th>
							<th>Customer</th>
							<th>Reseller discount</th>
						</thead>
						<tbody id="line_detail_tbody_${window.GLOBALint}">
						</tbody>
					</table>
				</td>
				</tr>
				`;
	$(selector).append(html);
	adddetail_line(window.GLOBALint,'send');
	window.GLOBALint++;

}
function decodeToken(){
   	let token = sessionStorage.getItem("token");
	var playload = JSON.parse(atob(token.split('.')[1]));
    return payload;
}
function submitform(){
	const element = document.getElementById('dealregisterform');
	const formData      = new FormData(element);
	const encodeData    = new URLSearchParams(formData);
	fetch("api/Deal", {
	    method: 'POST',
	    body: encodeData
	}).then(function(response) {
	    if(response.status == 200){
	    	console.log(response.text());
	        return response.text();
	    }else{
	        $.notify("Something went wrong");
	    }
	})
	    .then(function(myJson) {
	    	if(myJson){

	        console.log(myJson);
	    	}
	    });

}
function adddetail_line(id,type){
	
	if(type == 'send'){
						var line_detail_td = `
						<tr >
							<td><input class="form-control" placeholder="amount" name="amount" type="text"></td>
							<td><input class="form-control" value="${type}"  placeholder="typeline" name="typeline" type="text"></td>
							<td><input class="form-control" type="text" placeholder="datumreceive" name="datumr"></td>
							<td><input class="form-control" type="text" placeholder="resseller" name="resseller"></td>
							<td><input class="form-control" type="text" placeholder="res_discount" name="res_discount"></td>
							<td><button  type="button" onclick="removesubline(this)">remove</button></td>
						</tr>`;
					}else{
		var line_detail_td = `
						<tr>
							<td><input class="form-control" placeholder="amount" name="amount" type="text"></td>
							<td><input class="form-control" value="${type}" placeholder="typeline" name="typeline" type="text"></td>
							<td><input class="form-control" placeholder="datumr" name="datumr" type="text"></td>
							<td colspan="2"></td>
							<td><button  type="button" onclick="removesubline(this)">remove</button></td>
						</tr>`;
					}
	

		$(`#line_detail_tbody_${id}`).append(line_detail_td);

}

function loaddeals(selector){
    $.getJSON('api/Deal', function(json, textStatus) {
        $.each(json, function(index, val) {
            let tablerow = `
    		 <tr id="${val.id}">
	    		 <td>${val.id}</td>
	    		 <td>${val.dealname}</td>
	    		 <td>${val.one_time_benefit}</td>
    		 </tr>`;
    		 $(selector + "_body").append(tablerow);
    	});
        $("#dealtable").DataTable();
    });
}
 function login(){
        const element = document.getElementById("loginForm");
        const formData      = new FormData(element);
        const encodeData    = new URLSearchParams(formData);
        fetch("api/users/login", {
            method: 'POST',
            body: encodeData
        }).then(function(response) {
            if(response.status == 200){

                return response.text();
            }else{
                $.notify("Username or password is not correct");
            }
        })
            .then(function(myJson) {
                if(myJson){
                    sessionStorage.setItem("token",myJson)
                    window.location.href  = "Homepage.html";
                }
            });
    }
function logout(){
	sessionStorage.clear();
}