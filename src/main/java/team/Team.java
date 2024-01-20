package team;

import java.util.ArrayList;

import GameEnviroment.GameLogic;
import athlete.Athlete;

/**
 * 
 * A team of debaters used to play matches
 *
 */
public class Team {
	
	/**
	 * the name of the team
	 */
	private String name;
	/**
	 * a list to contain the members of the team
	 */
	private ArrayList<Athlete> teamMemberList = new ArrayList<Athlete>();
	/**
	 * the first speaker initialised to the null athlete
	 */
	private Athlete firstSpeaker = GameLogic.nullAthlete;
	/**
	 * the second speaker initialised to the null athlete
	 */
	private Athlete secondSpeaker = GameLogic.nullAthlete;
	/**
	 * the third speaker initialised to the null athlete
	 */
	private Athlete thirdSpeaker = GameLogic.nullAthlete;
	/**
	 * the fourth speaker initialised to the null athlete
	 */
	private Athlete fourthSpeaker = GameLogic.nullAthlete;
	
	
	/**
	 * the default constructor, sets name to a default name
	 */
	public Team() {
		setName("Default Name");
	}
	
	/**
	 * the constructor used to give the team a custom name
	 * 
	 * @param name the name of the team
	 */
	public Team(String name) {
		setName(name);
	}
	
	/**
	 * gets the teams name
	 * 
	 * @return name the teams name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the teams name
	 * 
	 * @param name the teams new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * makes sure that a given athlete can only occupy one of the speaker positions
	 * 
	 * @param selectedAthlete a given athlete
	 */
	public void speakerClashFixer(Athlete selectedAthlete) {

			if(getFirstSpeaker() == selectedAthlete){
				this.firstSpeaker = GameLogic.nullAthlete;
			}
			if(getSecondSpeaker() == selectedAthlete){
				this.secondSpeaker = GameLogic.nullAthlete;
			}		
			if(getThirdSpeaker() == selectedAthlete){
				this.thirdSpeaker = GameLogic.nullAthlete;
				}	
			if(getFourthSpeaker() == selectedAthlete){
				this.fourthSpeaker = GameLogic.nullAthlete;
				}
	}
	
	/**
	 * gets the first speaker
	 * 
	 * @return firstSpeaker the first speaker
	 */
	public Athlete getFirstSpeaker() {
		return firstSpeaker;
	}
	
	/**
	 * sets the first speaker
	 * 
	 * @param firstSpeaker the new first speaker
	 */
	public void setFirstSpeaker(Athlete firstSpeaker) {
		speakerClashFixer(firstSpeaker);
		this.firstSpeaker = firstSpeaker;
	}
	
	/**
	 * gets the second speaker
	 * 
	 * @return secondSpeaker the second speaker
	 */
	public Athlete getSecondSpeaker() {
		return secondSpeaker;
	}
	
	/**
	 * sets the second speaker
	 * 
	 * @param secondSpeaker the new second speaker
	 */
	public void setSecondSpeaker(Athlete secondSpeaker) {
		speakerClashFixer(secondSpeaker);
		this.secondSpeaker = secondSpeaker;
	}
	
	/**
	 * gets the third speaker
	 * 
	 * @return thirdSpeaker the third speaker
	 */
	public Athlete getThirdSpeaker() {
		return thirdSpeaker;
	}
	
	/**
	 * sets the third speaker
	 * 
	 * @param thirdSpeaker the new third speaker
	 */
	public void setThirdSpeaker(Athlete thirdSpeaker) {
		speakerClashFixer(thirdSpeaker);
		this.thirdSpeaker = thirdSpeaker;
	}
	
	/**
	 * gets the fourth speaker
	 * 
	 * @return fourthSpeaker the fourth speaker
	 */
	public Athlete getFourthSpeaker() {
		return fourthSpeaker;
	}
	
	/**
	 * sets the fourth speaker
	 * 
	 * @param fourthSpeaker the new fourth speaker
	 */
	public void setFourthSpeaker(Athlete fourthSpeaker) {
		speakerClashFixer(fourthSpeaker);
		this.fourthSpeaker = fourthSpeaker;
	}
	
	/**
	 * gets the list of team members
	 * 
	 * @return teamMemberList the list of team members
	 */
	public ArrayList<Athlete> getTeamMemberList() {
		return teamMemberList;
	}
	
	/**
	 * adds a new team member to the list of team members if the size of the team members list is lower than 9
	 * 
	 * @param athlete the new team member
	 */
	public void addTeamMember(Athlete athlete) {
		teamMemberList.add(athlete);
		
	}
	
	/**
	 * sets the team member list to a given team member list
	 * 
	 * @param team a list of athletes
	 */
	public void setTeamMemberList(ArrayList<Athlete> team) {
		teamMemberList = team;
	}
	/**
	 * returns a string contains a description of the team
	 * 
	 * @return a description of the team
	 */
	@Override
	public String toString() {
		String returnString = "";
		for(Athlete teamMember : teamMemberList) {
			returnString = returnString + teamMember + "\n\n";
		}
		return "Team Name: " + name + "\n"+returnString;
	}
	

}
