function checkPassword() {
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPass").value;
    let submitBtn = document.getElementById("submitBtn");
    let pswrdMatch = document.getElementById("pswrdMatchMsg");

    if (password == confirmPassword) {
        submitBtn.disabled=false;
        pswrdMatch.hidden=true;
    }
    else{
        submitBtn.disabled=true;
        pswrdMatch.hidden=false;
    }
   setTimeout(()=>{ checkPassword() },100);
}

document.addEventListener("load",checkPassword());
