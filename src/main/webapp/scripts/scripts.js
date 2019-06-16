
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
