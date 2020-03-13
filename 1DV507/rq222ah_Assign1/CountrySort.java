package rq222ah_Assign1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Rashed Qazizada
 *
 */
public class CountrySort {

	private static String[] COUNTRIES = { "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola",
			"Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria",
			"Azerbaijan", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda",
			"Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil",
			"British Indian Ocean Territory", "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
			"Cote d'Ivoire", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
			"Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands",
			"Colombia", "Comoros", "Congo", "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic",
			"Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor",
			"Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Faeroe Islands",
			"Falkland Islands", "Fiji", "Finland", "Former Yugoslav Republic of Macedonia", "France", "French Guiana",
			"French Polynesia", "French Southern Territories", "Gabon", "Georgia", "Germany", "Ghana", "Gibraltar",
			"Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
			"Haiti", "Heard Island and McDonald Islands", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
			"Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan",
			"Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya",
			"Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali",
			"Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia",
			"Moldova", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru",
			"Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger",
			"Nigeria", "Niue", "Norfolk Island", "North Korea", "Northern Marianas", "Norway", "Oman", "Pakistan",
			"Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn Islands", "Poland",
			"Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russia", "Rwanda", "Sqo Tome and Principe",
			"Saint Helena", "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon",
			"Saint Vincent and the Grenadines", "Samoa", "San Marino", "Saudi Arabia", "Senegal", "Seychelles",
			"Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
			"South Georgia and the South Sandwich Islands", "South Korea", "Spain", "Sri Lanka", "Sudan", "Suriname",
			"Svalbard and Jan Mayen", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania",
			"Thailand", "The Bahamas", "The Gambia", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia",
			"Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Virgin Islands", "Uganda", "Ukraine",
			"United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands",
			"Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Wallis and Futuna",
			"Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe" };

	public static void main(String[] args) {
		// Task 1: Sort country names based on their length (longest first) and print
		// a list of the ten countries with longest names

		Comparator<String> longestName = (r1, r2) -> r2.length() - r1.length();
		Arrays.sort(COUNTRIES, longestName);
		System.out.println("\nCountries with longest names");
		for (int i = 0; i < 10; i++)
			System.out.println("\t" + COUNTRIES[i]);

		// Task 2: Sort country names in reverse alphabetic order and print a list
		// of the ten first countries in that list

		Comparator<String> reverseAlphabetic = (r1, r2) -> r2.charAt(0) - r1.charAt(0);
		Arrays.sort(COUNTRIES, reverseAlphabetic);
		System.out.println("\nCountries with shortest names");
		for (int i = 0; i < 10; i++)
			System.out.println("\t" + COUNTRIES[i]);

		// Task 3: Sort country names based on the number of As (A or a) they
		// contain print a list of the ten countries with most As

		Comparator<String> countAs = (m1, m2) -> (int) (m2.chars().filter((c) -> c == 'A' || c == 'a').count()
				- m1.chars().filter((c) -> c == 'A' || c == 'a').count()); // Must be updated
		Arrays.sort(COUNTRIES, countAs);
		System.out.println("\nCountry names containing most As (either A or a)");
		for (int i = 0; i < 10; i++)
			System.out.println("\t" + COUNTRIES[i]);

	}

}
