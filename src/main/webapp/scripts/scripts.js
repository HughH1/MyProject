
function checkServer(type, id, url, object) {
    return new Promise((resolve, reject) => {
        const req = new XMLHttpRequest();
        req.onreadystatechange = () => {
            if (req.readyState === 4) {
                if (req.status >= 200 && req.status < 300) {
                    resolve(req);
                }
                else {
                    reject("Something went wrong");
                }
            }
        }

        if (type === "POST") {
            req.open(type, url);
            req.setRequestHeader("Content-Type", "application/json");
            req.send(object);
        } else if (type === "DELETE") {
            req.open(type, url + "/" + id);
            req.setRequestHeader("Content-Type", "application/json");
            req.send();
        }
        else {
            req.open(type, url + "/" + id);
            req.setRequestHeader("Content-Type", "application/json");
            req.send(object);
        }
    });
}

let myVal = document.getElementById("theInput");

function search() {

    let value = myVal.value;

    checkServer("GET", value, "http://35.234.153.117:8080/SkateTricks-1.0/api/viewTrickName").then((req) => {
        let tricks = JSON.parse(req.responseText);
        tricks = tricks[0]
        sessionStorage.setItem("tricks", req.responseText);
        document.getElementById("trickName").innerHTML = tricks.trick;
        document.getElementById("trickDesc").innerHTML = tricks.desc;
        document.getElementById("trickProgress").innerHTML = tricks.progress;
        document.getElementById("trickDifficulty").innerHTML = tricks.difficulty;

        document.getElementById("uTrickName").value = tricks.trick;
        document.getElementById("uDesc").value = tricks.desc;
        document.getElementById("uProgress").value = tricks.progress;
        document.getElementById("uDifficulty").value = tricks.difficulty;

    }).catch(error => {
        console.log(error);
    });
}


function createTrick() {
    let createdTrick = {};

    createdTrick.trick = document.getElementById("cTrickName").value;
    createdTrick.desc = document.getElementById("cDesc").value;
    createdTrick.progress = document.getElementById("cProgress").value;
    createdTrick.difficulty = document.getElementById("cDifficulty").value;

    JSON.stringify(createdTrick);

    checkServer("POST", null, "http://35.234.153.117:8080/SkateTricks-1.0/api/createTrick", JSON.stringify(createdTrick)).then((req) => {

        console.log(createdTrick).catch((error) => console.log(error));
    });
}





function updateTrick() {
    let id = JSON.parse(sessionStorage.getItem("tricks"));
    trickId = id[0];

    let currentTrick = document.getElementById("trickName").innerText;
    let currentDesc = (document.getElementById("trickDesc")).innerText;
    let currentProgress = (document.getElementById("trickProgress")).innerText;
    let currentDifficulty = (document.getElementById("trickDifficulty")).innerText;

    let newTrick = document.getElementById("uTrickName").value;
    let newDesc = document.getElementById("uDesc").value;
    let newProgress = document.getElementById("uProgress").value;
    let newDifficulty = document.getElementById("uDifficulty").value;

    const updatedTrick = {
        trick: (newTrick && newTrick != currentTrick) ? newTrick : currentTrick,
        desc: (newDesc && newDesc != currentDesc) ? newDesc : currentDesc,
        progress: (newProgress && newProgress != currentProgress) ? newProgress : currentProgress,
        difficulty: (newDifficulty && newDifficulty != currentDifficulty) ? newDifficulty : currentDifficulty,
    };

    console.log(updatedTrick);

    checkServer("PUT", trickId.id, "http://35.234.153.117:8080/SkateTricks-1.0/api/updateTrick",
        JSON.stringify(updatedTrick)).then((req) => {
            console.log("updated");
        });

}

function deleteTrick() {
    let id = JSON.parse(sessionStorage.getItem("tricks"));
    trickId = id[0];
    checkServer("DELETE", trickId.id, "http://35.234.153.117:8080/SkateTricks-1.0/api/delete").then((req) => {
        console.log("Trick deleted!");
        let theVal = "Trick has been deleted";
        document.getElementById("deleteConfirmed").innerHTML = theVal;
    });
}