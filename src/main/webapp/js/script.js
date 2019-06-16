
function tester() {
    console.log("TEST");
}




function theInput() {
    let inp = document.getElementById("inputName").value;
    nameCheck(inp).then((myAccount) => {
        if (myAccount) {
            window.sessionStorage.setItem("Name", myAccount);
            window.location.href = 'file:///C:/Users/Admin/Documents/WebDev/website%20with%20db/view.html';
        }
        else {
            let account = new Account(inp);
            let myAccount = JSON.stringify(account);
            sendData(myAccount, "http://localhost:8080/JavaEEServer-1.0/api/accounts/").then(({ responseText }) => {
                console.log(myAccount);
                window.sessionStorage.setItem("Name", myAccount);
                window.location.href = 'file://C:/Users/Hugo/Documents/_QA/IndivdualProject/frontend/index.html';
            });
        }
    });
}


function sendData(data, url) {
    return new Promise((resolve, reject) => {
        const req = new XMLHttpRequest();
        req.onreadystatechange = () => {
            if (req.readyState === 4) {
                if (req.status === 201) {
                    resolve(req);
                }
                else {
                    reject("It went wrong");
                }
            }
        }
        req.open("POST", url);
        req.setRequestHeader("Content-Type", "application/json");
        req.send(data);
    });
}