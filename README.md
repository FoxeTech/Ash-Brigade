# Ash-Brigade

Some game we're making. Yeah that's all we gotta say for now.

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