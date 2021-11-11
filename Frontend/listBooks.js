

fetch('http://localhost:8080/Gradle___org_example___LibraryProject_1_0_SNAPSHOT_war/books/allbooks')
    .then(function (response) {
        return response.json();
    })
    .then(function (books) {
        showAllBooksInTable(books);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });

    function showAllBooksInTable(books) {
        const mainContainer = document.getElementById("booksTable");
        for (var i = 0; i < books.length; i++) {
            const tr = document.createElement("tr");
            const tdBookName = document.createElement("td");
            tdBookName.innerHTML = books[i].bookName;
            const tdIsbn = document.createElement("td");
            tdIsbn.innerHTML = books[i].isbn
            const tdAgeRestriction = document.createElement("td");
            tdAgeRestriction.innerHTML = books[i].ageRestriction;
            const tdAvailable = document.createElement("button");
            tdAvailable.innerHTML = "borrow";
            const tdAvailableBlank = document.createElement("td");
            tdAvailableBlank.innerHTML = "not available";




            tr.appendChild(tdBookName);
            tr.appendChild(tdIsbn);
            tr.appendChild(tdAgeRestriction);

            if (books[i].lendOut === true){
                tr.appendChild(tdAvailable);
            } else {
                tr.appendChild(tdAvailableBlank);
            }
            mainContainer.appendChild(tr);


        }
}