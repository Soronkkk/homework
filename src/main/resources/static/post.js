$(document).ready(
    function () {

        // SUBMIT FORM
        $("#employeeForm").submit(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {

            // PREPARE FORM DATA
            var formData = {
                employeeId: $("#employeeId").val(),
                employeeName: $("#employeeName").val(),
                employeeSurname: $("#employeeSurname").val(),
                employeeSalary: $("#employeeSalary").val(),
                employeeJobTitle: $("#employeeJobTitle").val()
            }

            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/saveEmployee",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (result) {
                    if (result.status == "success") {
                        $("#postResultDiv").html(
                            "" + result.data.employeeName
                            + "Post Successfully! <br>"
                            + "---> Congrats !!" + "</p>");
                    } else {
                        $("#postResultDiv").html("<strong>Error</strong>");
                    }
                    console.log(result);
                },
                error: function (e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });

        }

    })