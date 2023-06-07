export default class FormValidator {

    constructor(form, fields) {
        this.form = form
        this.fields = fields
    }

    validateOnEntry() {
        let self = this
        this.fields.forEach(field => {
            const input = document.querySelector(`#${field}`)

            input.addEventListener('blur', () => {
                self.validateFields(input)
            })
        })
    }

    validateFields(field) {
        switch (true) {
            case (field.value.trim() === ""): {
                this.setStatus(field, "Заповніть дане поле", "error");
                break;
            }
            case (field.attr('name').contains('name') && field.value < 3): {
                let errorName;
                if (field.attr('name') === "firstname") {
                    errorName = 'ім\'я'
                } else {
                    errorName = 'прізвище'
                }
                this.setStatus(field, `Ваше ${errorName} має містити більше 2 символів`, "error");
                break;
            }
            case (field.attr('name') === 'email' && !(field.value.contains('@') && field.value.contains('.\w+\g'))): {
                this.setStatus(field, 'Введіть правильну пошту');
                break;
            }
            default: {
                this.setStatus(field, null, 'success');
                break;
            }
        }
    }

    setStatus(field, message, status) {
        const successfulIcon = field.parentElement.querySelector('.icon-success');
        const errorIcon = field.parentElement.querySelector('.icon-error');
        const errorMessage = field.parentElement.querySelector('.icon-message');

        if (status === 'success') {
            if (errorIcon) {
                errorIcon.classList.add('hidden');
            }
            if (errorMessage) {
                errorMessage.innerHTML = "";
            }
            successfulIcon.classList.remove('hidden')
            field.classList.remove("border-danger");
        }
        if (status === "error") {
            if (successfulIcon) {
                successfulIcon.classList.add('hidden');
            }
            field.parentElement.querySelector('.error-message').innerHTML = message + "<sup>*</sup>";
            errorIcon.classList.remove('hidden');
            field.classList.add("border-danger");
        }
    }
}