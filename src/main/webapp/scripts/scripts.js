
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
    let theTrick = {};

    theTrick.trick = document.getElementById("cTrickName").value;
    theTrick.desc = document.getElementById("cDesc").value;
    theTrick.progress = document.getElementById("cProgress").value;
    theTrick.difficulty = document.getElementById("cDifficulty").value;

    JSON.stringify(theTrick);

    checkServer("POST", null, "http://35.234.153.117:8080/SkateTricks-1.0/api/createTrick", JSON.stringify(theTrick)).then((req) => {

        console.log(theTrick);
    });
}

function updateTrick() {
    let id = myVal;

    let theTrick = {};

    let currentTrick = document.getElementById("trickName").value;
    let currentDesc = document.getElementById("trickDesc").value;
    let currentProgress = document.getElementById("trickProgress").value;
    let currentDifficulty = document.getElementById("trickDifficulty").value;

    let newTrick = document.getElementById("uTrickName").value;
    let newDesc = document.getElementById("uTrickDesc").value;
    let newProgress = document.getElementById("uTrickProgress").value;
    let newDifficulty = document.getElementById("uTrickDifficulty").value;

    if (newTrick != currentTrick && newTrick != null && newTrick != undefined) {
        theTrick.trick = newTrick;
    }
    else {
        theTrick.trick = currentTrick;
    }
    if (newDesc != currentDesc && newDesc != null && newDesc != undefined) {
        theTrick.desc = newDesc;
    } else {
        theTrick.desc = currentDesc;
    }
    if (newProgress != currentProgress && newProgress != null && newProgress != undefined) {
        theTrick.progress = newProgress
    } else {
        theTrick.progress = currentProgress
    }
    if (newDifficulty != currentDifficulty && newDifficulty != null && newDifficulty != undefined) {
        theTrick.difficulty = newDifficulty;
    } else {
        theTrick.difficulty = currentDifficulty;
    }

    console.log(theTrick);

    // checkServer("PUT", id, "http://35.234.153.117:8080/SkateTricks-1.0/api/updateTrick", JSON.stringify(theTrick)).then((req) => {
    //     console.log("updated");
    // });

}


