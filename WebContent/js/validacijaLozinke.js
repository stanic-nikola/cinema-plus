function proveri()
{
    if(document.forma.lozinka.value.length <1)
    {
        document.getElementById('ispis').innerHTML = '<div class="alert alert-danger" role="alert">Lozinka mora imati više od 6 karaktera!</div>';
        return  false;
    }
    else
    {
        if(jednake() === true)
        {
            return  true;
        }
        else
        {
            return false;
        }
    }
}


function jednake() {
    if(document.forma.lozinka.value != document.forma.ponoviLozniku.value)
    {
        document.getElementById('ispis').innerHTML = '<div class="alert alert-danger" role="alert">Lozinke se ne poklapaju!</div>';
        return false;
    }
    else
    {
        document.getElementById('ispis').innerHTML = '';
        return true;
    }
}

function skloni(){
	document.getElementById('skloni').style.visibility = 'hidden';
}
