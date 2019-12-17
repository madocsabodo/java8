package com.msg.java8;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterManagement {
	
	private static final String CSV_FILE_STRING = "character-predictions.csv";
	private static final String SPLIT_STRING = ",";
	
	List<Character> characters = new ArrayList<Character>();
	
	public void readCharacters() {	
		    String line = "";      
	        try ( BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_STRING))) {     
	        	
	            while ((line = br.readLine()) != null) {
	              
	                String[] data = line.split(SPLIT_STRING); 
	                
	                Character character = new Character(Integer.parseInt(data[0]),data[5], data[6]);
	            
	                character.setMale (!"".equals(data[7]) ?  Integer.parseInt(data[7]) == 1? true : false  : null );
	                character.setMother(data[11]);
	                character.setFather(data[12]);
	                character.setHouse(data[14]);
	                character.setSpouse(data[15]);
	                character.setMarried(Boolean.parseBoolean(data[25]));
	                character.setNoble(Boolean.parseBoolean(data[26]));
	                character.setAge(!"".equals(data[27]) ? Integer.parseInt(data[27]) : null);
	                characters.add(character);
	                
	                System.out.println(character.toString());
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } 	       
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> maleStarkList(){
		
		List<String> starkFamily = characters.stream().filter(item -> item.isMale()==false && item.getAge() != null )
				.sorted(Comparator.comparing(Character::getAge)).map(Character::getName).collect(Collectors.toList());
	
		return starkFamily;		
	} 
	
	/**
	 * 
	 * @return
	 */
	public long maleStarkCount(){
		
		return  characters.
				stream().
				filter(item -> item.getHouse().equals("House Stark") ).
				count();	
	}
	
	/**
	 * 
	 * @param house
	 * @return
	 */
	public Integer totalAgePerHouse(String house) {
		Integer totalAge = characters.
					stream().
					filter(item -> house.equals(item.getHouse())).
					filter(item -> item.getAge() != null).
					map(item -> item.getAge()).
					reduce(0, (a,b) -> a +b);
	
		return totalAge;		
	}
	
	
	

}
