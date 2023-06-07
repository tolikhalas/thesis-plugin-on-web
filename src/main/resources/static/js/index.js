let employee_form = document.getElementById('employee_form');
let xhr = new XMLHttpRequest();

let firstNameInput = document.querySelector('input#firstname');
let lastNameInput = document.querySelector('input#lastname');
let positionInput = document.querySelector('select#position');
let dobInput = document.querySelector('input#dob');
let emailInput = document.querySelector('input#email');


employee_form.onsubmit = function () {

    let user = {
        firstname: String( firstNameInput.value ),
        lastname: String ( lastNameInput.value ),
        position: String ( positionInput.value ),
        dob: new Date(dobInput.value),
        email: String ( emailInput.value ),

    }
    xhr.open('POST', '/');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(user));

    return false;
};

