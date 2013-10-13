# language: de

Funktionalität: Login
  Der Benutzer loggt sich an der SSO ein, damit er auf geschützten Content zugreifen kann.
  
  @Login1
  Szenario: Formbasiertes Login
    Angenommen ein User befindet sich auf der Startseite des Test-Dienstes "testdienst-dev".
    Und klickt auf den button "zum sicheren Bereich für WEB LOW".
    Dann öffnet sich das Loginformular "Login".
    Wenn der User "Bob" seine Credentials eingibt und das Formular absendet.
    Dann wird er auf die Seite "It works protected" des Dienstes weitergeleitet.
    