$(document).ready(
    function () {


        // SUBMIT FORM
        $("#departmentForm").submit(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {

            // PREPARE FORM DATA
            var formData = {
                id: $("#departmentId").val(),
                name: $("#departmentName").val(),
                description: $("#departmentDescription").val()
            }

            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "departments",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (result) {

                    if (result.status == "success") {
                        $("#postResultDiv").html(
                            "" + result.data.name
                            + "Post Successfully! <br></p>");
                    } else {
                        var errors = "";
                         if(result.nameError != undefined){
                             errors+=result.nameError;
                         }
                         if(result.descriptionError != undefined){
                             errors+="  " + result.descriptionError;
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

function deleteDepartment(row) {
    $.ajax({
        type: "DELETE",
        url: "departments/" + row.children[0].innerText,
        success: function (data) {
            row.remove();
        }
    });
}

$(document).ready(
    function () {

        // SUBMIT FORM
        $("#updateDepartment").click(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPut();
        });

        function ajaxPut() {

            // PREPARE FORM DATA
            var formData = {
                id: $("#departmentId").val(),
                name: $("#departmentName").val(),
                description: $("#departmentDescription").val()
            }

            // DO PUT
            $.ajax({
                type: "PUT",
                contentType: "application/json",
                url: "departments",
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
                        if(result.descriptionError != undefined){
                            errors+="  " + result.descriptionError;
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