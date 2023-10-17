# Java - Objektni razvoj softvera
### Application.java

Iz imdb.txt(koji predstavlja idmb.html fajl) izvlači ime filma,ime režisera(director),ime glavnog glumca,ime sporednog glumaca,godinu objavljivanja filma kao  ocjenu na imdb pllatformi.Movie klasa modeluje film,sa svim potrebnim poljima.Imamo klasu koja služi za modelovanje glumca i režisera.
Podaci se smještaju u fajl myimdb.txt gdje svaka linija predstavlja navedene podatke filma odvojene znakom '#'. 

### Application.java

Pravi kolekciju svih filmova iz fajla imdb.txt.Vrši se sortiranje filmova po godini objave,zatim se pravi mapa gdje je kljuc String ime glumca,a value broj,
ako je glavni glumac u filmu dobija 1poen,sporedna uloga 0.4.Ta mapa je sortirana  i istampana.
