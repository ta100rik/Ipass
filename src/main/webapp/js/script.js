
$(document).ready(function() {
	$(document).on('click', '#login_button', function(event) {
		event.preventDefault();
		login();
	});
	checklogin();
});
function checklogin(){
    let token = sessionStorage.getItem("token");
    let login = document.getElementById("loginbox");
    console.log(checklogin());
    if(token){
        window.location.href = "Homepage.html";
    }else{
        window.location.href = "index.html";
    }
}
 function login(){
        const element = document.getElementById("loginForm");
        const formData      = new FormData(element);
        const encodeData    = new URLSearchParams(formData);
        fetch("api/users", {
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