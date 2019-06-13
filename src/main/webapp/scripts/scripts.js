
function fetchData(type, id, url) {
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
        req.open(type, url + "/" + id);
        req.send();
    });
}

let myVal = document.getElementById("theInput");


function search() {
    let value = myVal.value;
    fetchData("GET", value, "http://35.234.153.117:8080/SkateTricks-1.0/api/viewTrick").then((req) => {
        let tricks = JSON.parse(req.responseText);
        document.getElementById("trickName").innerHTML = tricks.trick;
        document.getElementById("trickDesc").innerHTML = tricks.desc;
        document.getElementById("trickProgress").innerHTML = tricks.progress;
        document.getElementById("trickDifficulty").innerHTML = tricks.difficulty;
        console.log(tricks);
    });
}

let cVal = document.getElementById("cUserInput");
cVal += " " + document.getElementById("cUserInput2");

function createTrick() {

    return new Promise((resolve, reject) => {

        const req = new XMLHttpRequest();
        req.onreadystatechange = () => {
            if (req.readyState === 4) {
                if (req.status === 201) {
                    resolve(req);
                }
                else {
                    reject("Create POST method didn't work");
                }
            }
        }
        req.open("POST", "http://35.234.153.117:8080/SkateTricks-1.0/api/createTrick");
        req.setRequestHeader("Content-Type", "application/json");
        req.send(JSON.stringify(cVal));
        console.log(parse(cVal));
    });
}