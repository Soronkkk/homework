$(document).ready(
    function() {

        // GET REQUEST
        $("#getEmployees").click(function(event) {
            event.preventDefault();
            ajaxGet();
        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type : "GET",
                url : "getEmployees",

                success : function(result) {
                    if (result.status == "success") {
                        $('#getResultDiv ul').empty();
                        var custList = "";
                        $.each(result.data,
                            function(i, employee) {
                                var employee = "Employee ID =" + employee.employeeId
                                    +", Name =  "+ employee.employeeName
                                    + ", Surname  = " + employee.employeeSurname
                                    + ", Salary = " + employee.employeeSalary
                                    + ", Job title = " + employee.employeeJobTitle
                                    + "<br>";
                                $('#getResultDiv .list-group').append(employee)
                            });
                        console.log("Success: ", result);
                    } else {
                        $("#getResultDiv").html("<strong>Error</strong>");
                        console.log("Fail: ", result);
                    }
                },
                error : function(e) {
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })