package pl.refactoring.interpreter.legacy;

public interface Spec {

	/**
	 * 1. In eclipse to "move refactor" use: ⌥ ⌘ V (alt + cmd + V)
	 * For full list check: https://www.shortcutfoo.com/app/dojos/eclipse-mac/cheatsheet
	 * Also cmd + shift + l open shortcut list.
	 * 
	 * 2. select method and extract to interface: 
	 * 2.1 cmd + shift + t
	 * 2.2 extract interface 
	 * @param estate
	 * @return
	 */
	boolean isSatisfiedBy(RealEstate estate);

}