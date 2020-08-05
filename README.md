Budowanie aplikacji:

mvn clean install


Uruchamianie aplikacji:

po zbudowaniu wejscie w katalog "target" i uruchomienie komendą java -jar mp3consoleapp-1.0-SNAPSHOT.jar




Opis projektu:
Program komputerowy imitujące odtwarzacz mp3.
Uruchomienie programu powoduje wymiarowanie jego opcji:
- 1 Odtwórz utwor
- 2 Pokaż listę utworow
- 3 Dodaj katalog
- 4 Zamknij

Odtwórz utwór ( po wpisaniu: 1,1 aplikacja uruchamia pierwszy utwór z listy utworow)

Pokaż listę utworow( aplikacja kosztuje wszystkie pliki w formacie mp3 znajdujące się w dodanym katalogu, jeżeli nie dodano katalogu wyświetla się komunikat " nie dodałeś katalogu"

Dodaj katalog: przykład: 3,"C:\muzyka" katalog zostaję dodany
Dodatkowa walidacja:
Podczas dodawania katalogu należy sprawdzić czy ścieżka istnieje jeżeli nie zwrócić odpowiedni komunikat użytkownikowi, jeżeli ścieżka istnieje to czy w katalogu jest co najmniej jeden plik o rozszerzeniu mp3 jeżeli nie zwrócić błąd.

Zamknij- zamyka aplikację 

Co należy uwzglednic:
Aby aplikacja działała płynnie ( np aby podczas grania utworu można było aplikację zamknąć lub wylistowac utwory należy podejść do tego wielowatkowo.
Po wybraniu jednej z opcji np 1,1 linia komend powinna zostać wyczyszczona, na gorze powinien pojawić się komunikat dla użytkownika np: "odtwarzane utwor: abcd"
I pod spodem menu aby zawsze użytkownik wiedział jakie ma opcję.
Nie powinno się ładować wszystkich plików mp3 do pamięci (co jeżeli takich plików by było 500Gb??) Należy ładować tylko tą aktualnie wykorzystywaną.

Co jeżeli po w czytaniu katalogu ktoś usunie jeden z utworow? Należy wziąć to pod uwagę.


Nice to have: użytkownik chciał by mieć opcję podczas odtwarzania utworu sprawdzić jego długość, zobaczyć która minuta utworu jest grana, moc to zaplanować,  przewinąć wznowić.