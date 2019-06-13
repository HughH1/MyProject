
function fetchData(id, url) {
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
        req.open("GET", url + "/" + id);
        req.send();
    });
}

let myVal = document.getElementById("theInput");


function search() {
    let value = myVal.value;
    fetchData(value, "http://35.234.153.117:8080/SkateTricks-1.0/api/viewTrick").then((req) => {
        let tricks = JSON.parse(req.responseText);
        document.getElementById("myOutput").innerHTML = tricks.trick;
        console.log(tricks);
    });
}



let userInput = document.getElementById("")

function createTrick() {
    return new Promise((resolve, reject)=>{
        const req = new XMLHttpRequest();
        req.open("POST", "http://35.234.153.117:8080/SkateTricks-1.0/api/createTrick");
        req.setRequestHeader("Content-Type", "application/json");

        

    });
    
    
    //function addAccount() {
    // let request = new XMLHttpRequest();
    // request.open("POST", "/JavaEEServer-1.0/api/accounts");
    // request.setRequestHeader("Content-Type", "application/json")
    // let body = {name: "Gaza"};
    // request.send(JSON.stringify(body));
    
    



}






// function sendReq() {
//     fetchData("localhost:8080/SkateTricks-1.0/api/viewTrick/").then((req) => {
//         let tricks = JSON.parse(req.responseText);
//         console.log(tricks);


//     });
// }


// function sendReq() {
//     const req = new XMLHttpRequest();
//     req.onreadystatechange = function myRequest() {
//         if (req.readyState === 4) {
//             let superHeroObject = JSON.parse(req.responseText);
//             for (let x in superHeroObject) {
//                 let paste = document.createElement("th");
//                 paste.innerText = x;
//                 document.getElementById("heading").appendChild(paste);
//               
//             }
//         }
//     }
//     req.open("GET", "https://raw.githubusercontent.com/ewomackQA/JSONDataRepo/master/example.json");
//     req.send();

// }