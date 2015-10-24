# Ash-Brigade

A multi-level 2D strategy game focused on ranking up and eventually taking over the fantasy world through a flexible storyline that changes based on what the player does.

# Temp code pastes:

***

## Networking example:
client = new UserClient(username, password);
client.setup();
private void setup() {
	try {
		boolean isPlaying = true;
		boolean isHost = true;
		client.setGame("localhost", 7777, isPlaying, isHost);
		client.getConnection().setClientCount(2);
		client.joinGame();
	} catch (IOException e) {
		e.printStackTrace();
	}
	// Unable to create/connect client, abandon networking
}
private void update() {
	client.getConnection().receive();
}

***
