
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

        if (type == "POST") {
            req.open(type, url);
            req.setRequestHeader("Content-Type", "application/json");
            req.send(object);
        }
        else {
            req.open(type, url + "/" + id);
            req.send(object);
        }
    });
}

let myVal = document.getElementById("theInput");

function search() {
    let value = myVal.value;
    checkServer("GET", value, "http://35.234.153.117:8080/SkateTricks-1.0/api/viewTrick").then((req) => {
        let tricks = JSON.parse(req.responseText);
        document.getElementById("trickName").innerHTML = tricks.trick;
        document.getElementById("trickDesc").innerHTML = tricks.desc;
        document.getElementById("trickProgress").innerHTML = tricks.progress;
        document.getElementById("trickDifficulty").innerHTML = tricks.difficulty;
    }).catch(error => {
        console.log(error);
    });
}


function createTrick() {
    let updatedTrick
        = {};

    updatedTrick
        .trick = document.getElementById("cTrickName").value;
    updatedTrick
        .desc = document.getElementById("cDesc").value;
    updatedTrick
        .progress = document.getElementById("cProgress").value;
    updatedTrick
        .difficulty = document.getElementById("cDifficulty").value;

    JSON.stringify(updatedTrick
    );

    checkServer("POST", null, "http://35.234.153.117:8080/SkateTricks-1.0/api/createTrick", JSON.stringify(updatedTrick
    )).then((req) => {

        console.log(updatedTrick
        );
    });
}

function updateTrick() {
    let id = myVal;

    let updatedTrick = {};

    let currentTrick = (document.getElementById("trickName")).innerHTML;
    let currentDesc = (document.getElementById("trickDesc")).innerHTML;
    let currentProgress = (document.getElementById("trickProgress")).innerHTML;
    let currentDifficulty = (document.getElementById("trickDifficulty")).innerHTML;

    console.log(currentTrick);
    console.log(currentDesc);
    console.log(currentProgress);
    console.log(currentDifficulty);

    let newTrick = document.getElementById("uTrickName").value;
    let newDesc = document.getElementById("uDesc").value;
    let newProgress = document.getElementById("uProgress").value;
    let newDifficulty = document.getElementById("uDifficulty").value;


    console.log(newTrick);
    console.log(newDesc);
    console.log(newProgress);
    console.log(newDifficulty);


    if (newTrick != currentTrick && newTrick != null && newTrick != undefined) {
        updatedTrick
            .trick = newTrick;
    } else {
        updatedTrick
            .trick = currentTrick;
    }

    if (newDesc != currentDesc && newDesc != null && newDesc != undefined) {
        updatedTrick
            .desc = newDesc;
    } else {
        updatedTrick
            .desc = currentDesc;
    }

    if (newProgress != currentProgress && newProgress != null && newProgress != undefined) {
        updatedTrick
            .progress = newProgress
    } else {
        updatedTrick
            .progress = currentProgress
    }

    if (newDifficulty != currentDifficulty && newDifficulty != null && newDifficulty != undefined) {
        updatedTrick
            .difficulty = newDifficulty;
    } else {
        updatedTrick
            .difficulty = currentDifficulty;
    }

    console.log(updatedTrick);

    checkServer("PUT", id, "http://35.234.153.117:8080/SkateTricks-1.0/api/updateTrick",
        JSON.stringify(updatedTrick)).then((req) => {
            console.log("updated");
        });

}


