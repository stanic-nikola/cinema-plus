function validiraj()
{
    if(proveraTelefona() === true)
    {
        return true;
    }
    else
    {
        return false;
    }
}

function proveraTelefona() {

    var pattern = /^\+[0-9]{11,13}$/g;

    var telefon = document.forma.brojMobilnog.value;

    var rezultat = telefon.match(pattern);
    if(rezultat == null)
    {
        document.getElementById('ispis').innerHTML = '<div class="alert alert-danger" role="alert">Niste uneli validan broj telefona!</div>';
        return false;
    }
    else
    {
        document.getElementById('ispis').innerHTML = '';
        return true;
    }
}