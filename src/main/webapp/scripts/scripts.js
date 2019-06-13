
function checkServer(type, id, url) {
    return new Promise((resolve, reject) => {
        const req = new XMLHttpRequest();
        req.onreadystatechange = () => {
            if (req.readyState === 4) {
                if (req.status === 200) {
                    resolve(req);
                }
                else {
                    reject("Something went wrong");
                }
            }
        }

        if (type == "DELETE" || type == "POST") {
            req.open(type, url);
        }
        else {
            req.open(type, url + "/" + id);
        }

        req.send();
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
    });
}


function createTrick() {
    let theTrick = {};

    theTrick.trick = document.getElementById("trickName").value;
    console.log(document.getElementById("trickName"));
    console.log(document.getElementById("trickName").value);
    theTrick.desc = document.getElementById("trickDesc").value;
    theTrick.progress = document.getElementById("trickProgress").value;
    theTrick.difficulty = document.getElementById("trickDifficulty").value;

    // JSON.stringify(theTrick)
    console.log(theTrick);
    
    checkServer("POST", null, "http://35.234.153.117:8080/SkateTricks-1.0/api/createTrick").then((req) => {

        console.log(theTrick);
    });
}


