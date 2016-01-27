# Ash-Brigade

AshBrigade is a fantasy game focused on a single unit in a military brigade. You are that unit, however you are nothing special, you don't have magical powers, you aren't destined by some fates to save the world, you are simply a soldier following orders in a chaotic war where there are few, but powerful Mages. The game is more thought out than just that currently, however our group has decided to not share any further details.

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
