function validirajUnos()
{
    var nazivRashoda = document.formaDodaj.nazivRashoda.value;
    var cenaRashoda = document.formaDodaj.cenaRashoda.value;

    var patternNaziv = /^[a-zA-Z0-9-_\/()ČčĆćŠšĐđŽž ]+$/g;
    var patternCena = /^[0-9]+$/g;

    var rezultatNaziv = nazivRashoda.match(patternNaziv);
    var rezultatRashoda = cenaRashoda.match(patternCena);

    if(rezultatNaziv == null)
    {
        alert("U nazivu rashoda ne smete koristiti specijalne karaktere");
        return false;
    }
    else
    {
        if(rezultatRashoda == null)
        {
            alert("Cena rashoda mora biti ceo broj!");
            return false;
        }
        else
        {
            return true;
        }
    }
}