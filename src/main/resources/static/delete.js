function deleteEmployee(row) {
    $.ajax({
        type: "DELETE",
        url: "/deleteEmployee/" + row.children[0].innerText,
        success: function (data) {
            row.remove();
        }
    });
}
