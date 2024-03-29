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
                id: $("#employeeId").val(),
                name: $("#employeeName").val(),
                surname: $("#employeeSurname").val(),
                salary: $("#employeeSalary").val(),
                jobTitle: $("#employeeJobTitle").val(),
                departmentName: $("#employeeDepartment").val()
            }

            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "employees",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (result) {

                    if (result.status == "success") {
                        $("#postResultDiv").html(
                            "" + result.data.name
                            + "Post Successfully! <br></p>");
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

function deleteEmployee(row) {
    $.ajax({
        type: "DELETE",
        url: "employees/" + row.children[0].innerText,
        success: function (data) {
            row.remove();
        }
    });
}

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
                jobTitle: $("#employeeJobTitle").val(),
                departmentName: $("#employeeDepartment").val()
            }

            // DO PUT
            $.ajax({
                type: "PUT",
                contentType: "application/json",
                url: "employees",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (result) {

                    if (result.status == "success") {
                        $("#postResultDiv").html(
                            "Put " + result.data.name
                            + " Successfully! <br></p>");
                    } else {
                        var errors = "";
                        if(result.nameError != undefined){
                            errors+=result.nameError;
                        }
                        if(result.surnameError != undefined){
                            errors+="  " + result.surnameError;
                        }
                        if(result.departmentNameError != undefined){
                            errors+="  " + result.departmentNameError;
                        }
                        if(result.salaryError != undefined){
                            errors+="  " + result.salaryError;
                        }
                        if(result.jobTitleError != undefined){
                            errors+="  " + result.jobTitleError;
                        }
                        $("#postResultDiv").html("<strong>" + errors + "</strong>");
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