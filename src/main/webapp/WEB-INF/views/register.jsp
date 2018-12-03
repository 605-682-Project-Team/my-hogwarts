<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="resources/images/hogwarts_crest_icon.ico">
    <link href="resources/css/lib/bootstrap.min.css" rel="stylesheet">
    <script src="resources/js/lib/bootstrap.min.js"></script>
    <link href="resources/css/register.css" rel="stylesheet">
    <title>My Hogwarts Registration</title>
</head>
<body class="bg-light">
<div class="container">
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4"
             src="resources/images/hogwarts-crest.png" alt="" width="200"
             height="200">
        <h2>Student Registration</h2>
    </div>
    <div>
        <form action="user/create" method="post">
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="firstname">First name</label> <input type="text"
                                                                     class="form-control" id="firstname"
                                                                     name="firstname" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="lastname">Last name</label> <input type="text"
                                                                   class="form-control" id="lastname" name="lastname"
                                                                   required>
                </div>
            </div>
            <div class="mb-3">
                <label for="email">Email</label> <input type="email"
                                                        class="form-control" id="email" name="email"
                                                        placeholder="someone@example.com"
                                                        required>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="password">Password</label> <input type="password"
                                                                  class="form-control" id="password" name="password"
                                                                  required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="passwordConfirmation">Password Confirmation</label> <input
                        type="password" class="form-control" id="passwordConfirmation"
                        oninput="check(this)" required>
                </div>
            </div>
            <hr class="mb-4">
            <div class="mb-3">
                <label for="streetAddress">Address</label> <input type="text"
                                                                  class="form-control" id="streetAddress"
                                                                  name="streetAddress" required>
            </div>
            <div class="row">
                <div class="col-md-4 mb-3">
                    <label for="city">City</label> <input type="text"
                                                          class="form-control" id="city" name="city" required>
                </div>
                <div class="col-md-4 mb-3">
                    <label for="state">State</label> <input type="text"
                                                            class="form-control" id="state" name="state" required>
                </div>
                <div class="col-md-4 mb-3">
                    <label for="zipcode">Zipcode</label> <input type="text"
                                                                class="form-control" id="zipcode" name="zipcode"
                                                                maxlength="5" minlength="5"
                                                                required>
                </div>
            </div>
            <hr class="mb-4">
            <div class="row">
                <div class="col-md-4 mb-3">
                    <label for="year">Year</label> <select
                        class="custom-select d-block w-100" id="year" name="year" required>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                </select>
                </div>
                <div class="col-md-4 mb-3">
                    <label for="muggleBorn">MuggleBorn</label> <select
                        class="custom-select d-block w-100" id="muggleBorn" name="muggleBorn" required>
                    <option value=""></option>
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>
                </div>
            </div>
            <button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>
            <p class="mt-5 mb-3 text-muted text-center">&copy; 2018 Hogwarts
                School of Witchcraft and Wizardry</p>
        </form>
    </div>
</div>
</body>
<script type='text/javascript'>
    function check(input) {
        if (input.value != document.getElementById('password').value) {
            input.setCustomValidity('Password Must be Matching.');
        } else {
            // input is valid -- reset the error message
            input.setCustomValidity('');
        }
    }
</script>

</html>