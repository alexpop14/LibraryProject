# -Datenbank erstellen
create database libraryAlex;
# -libraryAlex nutzen?
use libraryAlex;
# -Tabelle Books erstellen
create table books(
  isbn int not null primary key,
  bookName varchar(255) not null,
  ageRestriction int not null
);
# -Tabelle Members erstellen
create table members(
    memberID int not null primary key,
    memberName varchar(255) not null,
    bDay date not null
);
# -Tabelle Loan erstellen
create table loan(
    loanID int not null primary key auto_increment,
    isbn int not null,
    memberID int not null,
    startOfLoan date not null,
    endOfLoan date not null,
    foreign key (isbn) references books(isbn),
    foreign key (memberID) references members(memberID)
);
#DELETE Members
delete from members where memberID = 83895802;
#DELETE books
delete from books where ageRestriction = 20;
#Test
INSERT INTO loan (isbn, memberID, startOfLoan, endOfLoan) VALUES (256391,26424155,CURRENT_DATE,(SELECT DATE_ADD(CURRENT_DATE, INTERVAL 30 DAY)));
#deleteLoan
delete from loan where loan.actualReturn is not null;
#SelectTest
SELECT isbn from loan where memberID = 26424155;

SELECT * from books where isbn = (SELECT isbn from loan where memberID = 26424155);

SELECT books.isbn,bookName from books inner join loan l on books.isbn = l.isbn where memberID = 26424155;

SELECT COUNT(*) as count from loan where isbn = 47411039;

INSERT INTO loan (isbn, memberID, startOfLoan, endOfLoan) VALUES (47411039,26424155,CURRENT_DATE,(SELECT DATE_ADD(CURRENT_DATE, INTERVAL 30 DAY)))
WHERE NOT EXISTS(SELECT COUNT(*) from loan where isbn = 47411039);



INSERT INTO loan (isbn, memberID, startOfLoan, endOfLoan) VALUES (47411039,26424155,CURRENT_DATE,(SELECT DATE_ADD(CURRENT_DATE, INTERVAL 30 DAY)))
SELECT DISTINCT ;


ALTER TABLE loan
    ADD actualReturn date not null;

ALTER TABLE loan
    MODIFY actualReturn date DEFAULT NULL;


SELECT COUNT(*) as count from loan where isbn = 67791741 AND actualReturn IS NOT NULL;


SELECT books.isbn,bookName, ageRestriction from books inner join loan l on books.isbn = l.isbn where memberID = 26424155 and actualReturn IS NULL;

SELECT isbn from loan where actualReturn IS NOT NULL;

SELECT books.isbn from books left join loan l on books.isbn = l.isbn where actualReturn
IS NOT NULL or NOT EXISTS (SELECT isbn from loan where books.isbn = loan.isbn);

SELECT isbn from books
WHERE NOT EXISTS (SELECT isbn from loan where books.isbn = loan.isbn);

SELECT books.isbn, bookName, ageRestriction, CASE WHEN actualReturn IS NULL THEN 0  ELSE 1 END as lendOut FROM books inner join loan l on books.isbn = l.isbn


SELECT memberID from members;