async function signIn(){
    const config = {
        auth: {
            clientId: '498cc182-a2f7-4de1-950c-85367adad63e',
            authority: 'https://login.microsoftonline.com/common/',
            redirectUri: 'http://drawlearning.azurewebsites.net/index.html'
        }
    };
    var client = new Msal.UserAgentApplication(config);
    var request = {
        scopes: ['user.read']
    };
    let loginResponse = await client.loginPopup(request);
    console.log("hola bienvenido ")
    localStorage.setItem("logeo", loginResponse.account.name)
    if (loginResponse.account.name === "Organizer"){
        app.createOrganizer(loginResponse.account.name)
    }else{

        app.createUser(loginResponse.account.userName)
    }
}