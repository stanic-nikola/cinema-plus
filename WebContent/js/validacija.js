function proveraLozinke()
{
    if(document.registracija.lozinka.value!=document.registracija.ponoviLozinku.value)
    {
        alert('Lozinke se ne poklapaju');
        document.registracija.ponoviLozinku.focus();
        return false;
    }
    else {
            if(document.registracija.lozinka.value.length >6){
                return true;
            }
            else
            {
                alert("Lozinka mora imati više od 6 karaktera");
                document.registracija.lozinka.focus();
                return  false;
            }
    }
}

function validacijaImena()
{
    var pattern = /^[a-zA-Z\u0161\u0111\u010D\u0107\u017EĐŠŽČĆ ]+$/g;
    var imeCheck = document.registracija.ime.value;

    var rezultat = imeCheck.match(pattern);
    if(rezultat == null)
    {
        alert("Niste uneli validno ime.");
        document.registracija.ime.focus();
        return false;
    }
    else{
        if (proveraLozinke() == true)
        {
            if(proveriMejl() == true)
            {
                if(proveraTelefona() == true)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else
        {
            return false;
        }
    }

}
function proveriMejl() {
    var pattern = /^[a-z0-9]+\.{0,1}[a-z0-9]+\@[a-z0-9]+\.[a-z]{2,6}$/g;

    var mejl = document.registracija.email.value;

    var rezultat = mejl.match(pattern);
    if(rezultat == null)
    {
        alert("Mejl nije validan!");
        document.registracija.email.focus();
        return false;
    }
    else
    {
        return true;
    }
}

function proveraTelefona() {

    var pattern = /^\+[0-9]{11,13}$/g;

    var telefon = document.registracija.brojMob.value;

    var rezultat = telefon.match(pattern);
    if(rezultat == null)
    {
        alert("Niste uneli validan broj telefona.");
        document.registracija.focus();
        return false;
    }
    else
    {
        return true;
    }
}

function zakljucaj()
{
    if(document.resetujLozinku.novaLozinka.value != document.resetujLozinku.potvrdiLozinku.value)
    {
        alert('Lozinke se ne poklapaju');
        document.resetujLozinku.potvrdiLozinku.focus();
        return false;
    }
    else
    {
        return true;
    }
}


function resetLozinke() {
    if(document.resetujLozinku.novaLozinka.value.length > 6)
    {
        if(zakljucaj() == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    else
    {
        alert("Lozinka mora imati više od 6 karaktera");
        document.resetujLozinku.novaLozinka.focus();
        return false;
    }
}


