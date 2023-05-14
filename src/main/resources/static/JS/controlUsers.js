async function signIn() {
  const isAdmin = confirm("¿Eres Admin?");
  const user = isAdmin ? "Admin" : "User";
  localStorage.setItem("logeo", user);
  if (user === "Admin") {
    app.createOrganizerM(user);
  } else {
    app.createUser(user);
  }
}