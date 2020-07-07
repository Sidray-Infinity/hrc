function validateForm() {
    if (validateFirstName() && validateEmail() && validateMessage())
        return true;

    return false;
}

function validateFirstName() {
    var x = document.forms["form"]["full_name"].value;
    if (x == "") {
        alert("Name field cannot be empty!");
        return false;
    }
    return true;
}

function validateEmail() {
    var x = document.forms["form"]["email"].value;
    if (x == "") {
        alert("Email field cannot be empty!");
        return false;
    }
    if (!x.includes("@")) {
        alert("Invalid email format!");
        return false;
    }
    return true;
}

function validateMessage() {
    var x = document.forms["form"]["message"].value;
    if (x == "") {
        alert("Message field cannot be empty!");
        return false;
    }
    return true;

}