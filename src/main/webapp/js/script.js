
$(document).ready(function() {
	$(document).on('click', '#login_button', function(event) {
		event.preventDefault();
		login();
	});
});
 function login(){
        const element = document.getElementById("loginForm");
        const formData      = new FormData(element);
        const encodeData    = new URLSearchParams(formData);
        fetch("Rest_Service/login", {
            method: 'POST',
            body: encodeData
        }).then(function(response) {
            if(response.status == 200){

                return response.text();
            }else{
                console.log("bad login");
            }
        })
            .then(function(myJson) {
                if(myJson){
                    localStorage.setItem("token",myJson)
                    window.location.href  = "Homepage.html";
                }
            });
    }