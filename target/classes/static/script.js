var table = document.getElementById("table");
var addRowBtn = document.getElementById("addRow");

function appendRow() {
    var buddyRow = document.createElement('tr')
    buddyRow.innerHTML = "<td><input> </td>";
    table.tBodies[0].insertBefore(buddyRow, table.rows[table.rows.length])
}

function submitBook() {
    var owner = document.getElementById("owner").value;
    var ownerObject = null
    var buddyObject = null
    const request = async () => {
        var res = await fetch('http://localhost:8080/buddyinfo', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({"name": owner})
        })
        ownerObject = await res.json();
        console.log(ownerObject)
        var buddies = []
        for (var i = 1; i < table.rows.length; i++) {
            var buddyName = table.rows[i].cells[0].firstElementChild.value
            res = await fetch('http://localhost:8080/buddyinfo', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({"name": buddyName})
            })
            buddyObject = await res.json();
            buddies.push(buddyObject._links.self.href)
        }
        res = await fetch('http://localhost:8080/addressbook', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "bookOwner": ownerObject._links.self.href,
                "buddies": buddies
            })
        })
        location.href = "result"
    }
    request()
}


addRowBtn.addEventListener("click", appendRow);
submit.addEventListener("click", submitBook);