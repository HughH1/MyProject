function deleteTrick() {
    let id = JSON.parse(sessionStorage.getItem("tricks"));
    trickId = id[0];
    checkServer("DELETE", trickId.id, "http://35.234.153.117:8080/SkateTricks-1.0/api/delete").then((req) => {
        console.log("Trick deleted!");
        window.alert("Trick has been deleted");
    });
}

let myVal = document.getElementById("theInput");