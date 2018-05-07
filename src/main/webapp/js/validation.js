$(function() {

    $("form[name='signUp']").validate({
        rules: {
            firstName: "required",
            lastName: "required",
            username: "required",
            birthYear: "required",
            pwd: {
                required: true,
                minlength: 5
            },
            repwd: {
                required: true,
                minlength: 5
            }
        },
        // Specify validation error messages
        messages: {
            firstName: "Please enter your firstname",
            lastName: "Please enter your lastname",
            userName: "Please enter your username",
            birthYear: "Please enter a year",
            pwd: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            repwd: {
                required: "Please re-enter your poassword",
                minlength: "Your password must be at least 5 characters long"
            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });

    $("form[name='signIn']").validate({
        rules: {
            username: "required",
            pwd: {
                required: true,
                minlength: 5
            }
        },
        // Specify validation error messages
        messages: {
            userName: "Please enter your username",
            pwd: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
        },
        submitHandler: function(form) {
            form.submit();
        }
    });

    $("form[name='orderForm']").validate({
        rules: {
            address: "required",
            city: "required",
            state: "required",
        },
        // Specify validation error messages
        messages: {
            address: "Enter an address",
            city: "Enter a city",
            state: "Enter a state"
        },
        submitHandler: function(form) {
            form.submit();
        }
    });

});
