function createTrick() {
    let createdTrick = {};

    createdTrick.trick = document.getElementById("cTrickName").value;
    createdTrick.desc = document.getElementById("cDesc").value;
    createdTrick.progress = document.getElementById("cProgress").value;
    createdTrick.difficulty = document.getElementById("cDifficulty").value;

    JSON.stringify(createdTrick);

    checkServer("POST", null, "http://35.234.153.117:8080/SkateTricks-1.0/api/createTrick", JSON.stringify(createdTrick)).then((req) => {
        window.alert("Trick has been created");

    });
}