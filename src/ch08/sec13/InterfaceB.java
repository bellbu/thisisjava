package ch08.sec13;

public sealed interface InterfaceB extends InterfaceA permits InterfaceD{
	void methodB();
}
