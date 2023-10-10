function display(data) {
    let content = '<h2> LIST STUDENT </h2>'
    content += `<table border="1"><tr>
<th>STT</th>
<th>NAME</th>
<th>DATE</th>
<th>ADDRESS</th>
<th>PHONE</th>
<th>EMAIL</th>
<th>CATEGORY</th>
<th colspan="2">Option</th>
</tr>`
    for (let i = 0; i < data.length; i++) {
        content += `<tr>
<td>${i + 1}</td>
<td>${data[i].name}</td>
<td>${data[i].date}</td>
<td>${data[i].address}</td>
<td>${data[i].phone}</td>
<td>${data[i].email}</td>
<td>${data[i].category.name}</td>
<td><button onclick="deleteStudent(${data[i].id})"> delete</button></td>
<td><button onclick="updateDisplayStudent(${data[i].id})"> update</button></td>
</tr>`
    }
    content += `</table >`
    document.getElementById("products").innerHTML = content;
}

function displayAll() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/students",
        success: function (data) {
            display(data)
        }
    });
}

function deleteStudent(id) {
    if (confirm("Are you sure?")) {
        $.ajax({
            type: "DELETE",
            url: `http://localhost:8080/api/students/${id}`,
            success: function () {
                alert("delete ok")
                displayAll()
            }
        });
    }
}

function save() {
    let newStudent ;
    let name = $("#name").val()
    let date = $("#date").val()
    let address = $("#address").val()
    let phone = $("#phone").val()
    let email = $("#email").val()
    let category = $("#category").val()
    let id = +localStorage.getItem("idUpdate")
    if(id!==-1){
        newStudent = {
            id :id,
            name: name,
            date: date,
            address: address,
            phone: phone,
            email: email,
            category: {
                id: category
            }
        };

    }else {
        newStudent = {
            name: name,
            date: date,
            address: address,
            phone: phone,
            email: email,
            category: {
                id: category
            }
    }

    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url : "http://localhost:8080/api/students",
        data :JSON.stringify(newStudent),
            success :function (){
            alert("ok")
                displayAll()
                localStorage.setItem("idUpdate", "-1")
            }

    });
    document.getElementById("form").reset()
//chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

function DB() {
    Category()
    displayAll();
}
function updateDisplayStudent(id) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/students/${id}`,
        success: function (student) {
            $("#name").val(`${student.name}`)
            $("#date").val(`${student.date}`)
            $("#address").val(`${student.address}`)
            $("#phone").val(`${student.phone}`)
            $("#email").val(`${student.email}`)
            $("#category").val(`${student.category}`)
            localStorage.setItem("idUpdate", student.id)

        }
    })
}
function search() {
    let search = $("#search").val()
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/students/search/" + search,
        success: function (data) {
            display(data)

        }
    })
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}
function Category() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/categories",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value=${data[i].id}>${data[i].name}</option>`;
            }
            document.getElementById("category").innerHTML = content;
        }
    })
}
function  displayCreate (){
    window.location.href ='Create.html';
}

