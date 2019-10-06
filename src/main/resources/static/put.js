$(document).ready(
    function () {

        // SUBMIT FORM
        $("#updateEmployee").click(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPut();
        });

        function ajaxPut() {

            // PREPARE FORM DATA
            var formData = {
                id: $("#employeeId").val(),
                name: $("#employeeName").val(),
                surname: $("#employeeSurname").val(),
                salary: $("#employeeSalary").val(),
                jobTitle: $("#employeeJobTitle").val()
            }

            // DO PUT
            $.ajax({
                type: "PUT",
                contentType: "application/json",
                url: "/updateEmployee/",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (result) {

                    if (result.status == "success") {
                        $("#postResultDiv").html(
                            "Put " + result.data.name
                            + " Successfully! <br></p>");
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