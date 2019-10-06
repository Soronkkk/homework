$(document).ready(
    function () {

        // GET REQUEST
        $("#getEmployees").click(function (event) {
            event.preventDefault();
            ajaxGet();
        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type: "GET",
                url: "getEmployees",

                success: function (result) {
                    if (result.status == "success") {
                        $('#getResultDiv ul').empty();
                         console.log(JSON.stringify(result.data));
                        $.each(result.data,
                            function printEmployee(i, employee) {

                            console.log(JSON.stringify(employee));


                                var row = document.createElement('tr');
                                var cell = document.createElement('td');
                                cell.innerHTML = employee.id;
                                row.appendChild(cell);
                                cell = document.createElement('td');
                                cell.innerHTML = employee.name;
                                row.appendChild(cell);
                                cell = document.createElement('td');
                                cell.innerHTML = employee.surname;
                                row.appendChild(cell);
                                cell = document.createElement('td');
                                cell.innerHTML = employee.salary;
                                row.appendChild(cell);
                                cell = document.createElement('td');
                                cell.innerHTML = employee.jobTitle;
                                row.appendChild(cell);
                                cell = document.createElement('td');
                                var button = document.createElement('button');
                                button.classList.add("btn");
                                button.classList.add("btn-link");
                                button.setAttribute('onclick', "editEmployee(this.parentNode.parentNode);");
                                button.innerText = "Edit";
                                cell.appendChild(button);
                                row.appendChild(cell);
                                cell = document.createElement('td');
                                button = document.createElement('button');
                                button.classList.add("btn");
                                button.classList.add("btn-link");
                                button.setAttribute('onclick', "deleteEmployee(this.parentNode.parentNode);");
                                button.innerText = "Delete";
                                cell.appendChild(button);
                                row.appendChild(cell);
                                document.getElementById("tbody-id").appendChild(row);
                            });
                        console.log("Success: ", result);
                    } else {
                        $("#getResultDiv").html("<strong>Error</strong>");
                        console.log("Fail: ", result);
                    }
                },
                error: function (e) {
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })