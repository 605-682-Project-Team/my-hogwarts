package edu.hogwarts.persistence.migration;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import edu.hogwarts.persistence.entity.Course;
import edu.hogwarts.persistence.entity.Course.CourseCategory;
import edu.hogwarts.persistence.repository.CourseRepository;

public class SeedDatabaseMigration {
	
	
	public static void main(String[] args) {
		
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-core-config.xml");
		
		CourseRepository courseRepository = ctx.getBean(CourseRepository.class);
		
		/**********************************************************************
		 *  CORE Courses
		 **********************************************************************/
		Course course = new Course();
		course.setName("Astronomy");
		course.setProfessor("Aurora Sinistra");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Astronomy is a core class and subject taught at Hogwarts School of Witchcraft and Wizardry and Uagadou School of Magic. Astronomy is a branch of magic that studies stars and the movement of planets. It is a subject where the use of practical magic during lessons isn't necessary.");
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Defense Against the Dark Arts");
		course.setProfessor("Remus Lupin");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Defense Against the Dark Arts is the class that teaches defensive magic to students so they can protect themselves against the Dark Arts. Often simply referred to as DADA class.\n" + 
				"\n" + 
				"The position of DADA professor was cursed by Tom Riddle when Dumbledore refused to let him teach at Hogwarts. Every professor only held the position for exactly one year, and their tenure ended in some drastic untimely way.");
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Charms");
		course.setProfessor("Filius Flitwick");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Charms is a course that teaches how to cast the class of spells known as Charms. These are spells that alter an object without changing its essential nature. Given a teapot, the spell that makes it tapdance across the desk would be a charm, the spell that turns it into a tortoise would not. This is a core subject, required of all Hogwarts students until at least their fifth year. ");
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Herbology");
		course.setProfessor("Pomona Sprout");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Herbology is the study of magical and mundane plants and fungi, making it the wizarding equivalent to botany. Herbology is a core class and subject taught at Hogwarts School of Witchcraft and Wizardry and Castelobruxo in which students learn to care for and utilise plants, learn about their magical properties and what they are used for. Many plants provide ingredients for potions and medicine, while others have magical effects of their own right.");
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Potions");
		course.setProfessor("Severus Snape");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Potions is a core class and subject taught at Hogwarts School of Witchcraft and Wizardry and Ilvermorny School of Witchcraft and Wizardry. In this class, students learn the correct way to brew potions. They follow specific recipes and use various magical ingredients to create the potions, starting with simple ones and moving to more advanced ones as they progress in knowledge. A standard potions kit includes plant ingredients such as Belladonna and supplies such as glass phials and weighing scales.");
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Transfiguration");
		course.setProfessor("Minerva McGonagall");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Transfiguration is a branch of magic that focuses on the alteration of the form or appearance of an object, via the alteration of the object's molecular structure. Transfiguration can be done to most (if not all) objects and, as with most forms of magic, it includes — but is hardly limited to — Transfiguration spells.");
		courseRepository.save(course);
		
		/**********************************************************************
		 *  ELECTIVE Courses
		 **********************************************************************/
		course = new Course();
		course.setName("Alchemy");
		course.setProfessor("Gilderoy Lockhart");
		course.setCategory(CourseCategory.ELECTIVE);
		course.setDescription("Alchemy is an elective course taught at Hogwarts School of Witchcraft and Wizardry. The course is open to sixth and seventh-years if there are enough students interested in taking the subject. The ancient science of Alchemy focuses on the study of nature's four basic elements (fire, earth, air, and water), as well as the transmutation of substances (such as base metals into gold).");
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Apparition");
		course.setProfessor("Horace Slughorn");
		course.setCategory(CourseCategory.ELECTIVE);
		course.setDescription("Apparition is an optional twelve-week course offered at Hogwarts School of Witchcraft and Wizardry for learning how to Apparate, with the intention of receiving a licence from the age of seventeen.");
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Care of Magical Creatures");
		course.setProfessor("Rebeus Hagrid");
		course.setCategory(CourseCategory.ELECTIVE);
		course.setDescription("Care of Magical Creatures is an elective course at Hogwarts School of Witchcraft and Wizardry and Ilvermorny School of Witchcraft and Wizardry that can be chosen by students in their third year. In the class, students learn about a wide range of magical creatures, from flobberworms to fire crabs, and even unicorns and thestrals. Students are taught about feeding, maintaining, breeding, and proper treatment of these creatures.");
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Divination");
		course.setProfessor("Sybill Trelawney");
		course.setCategory(CourseCategory.ELECTIVE);
		course.setDescription("Divination is an elective course taught at Hogwarts School of Witchcraft and Wizardry. It teaches methods of divining the future, or gathering insights into future events, through various rituals and tools. The magic taught in this class, as well as the ability to say prophetic things is a branch of magic referred to as \"Divination.\"");
		courseRepository.save(course);
		
		/**********************************************************************
		 *  Extra-curricular Courses
		 **********************************************************************/
		
		course = new Course();
		course.setName("Frog Choir");
		course.setProfessor("Filius Flitwick");
		course.setCategory(CourseCategory.EXTRA_CURRICULAR);
		course.setDescription("The Frog Choir was a singing group of Hogwarts students conducted by Professor Filius Flitwick. They usually practised in the Great Hall. The choir is quite talented, being able to both sing fluently in Latin as well as polyphonically.");
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Magical Theory");
		course.setProfessor("Quirinus Quirrell");
		course.setCategory(CourseCategory.EXTRA_CURRICULAR);
		course.setDescription("Magical Theory is a subject taught at Hogwarts School of Witchcraft and Wizardry, taken at least in the first year. It covers magic from a purely theoretical standpoint, including the topic of how spells work, according to the ad for the book Magical Theory.");
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Ancient Studies");
		course.setProfessor("Bathsheda Babbling");
		course.setCategory(CourseCategory.EXTRA_CURRICULAR);
		course.setDescription("Ancient Studies is an extra-curricular class taught at Hogwarts School of Witchcraft and Wizardry. The subject presumably focuses on ancient magic, such as the ancient Egyptians' spells. This class is taught in a classroom on the sixth-floor corridor.");
		courseRepository.save(course);
		
		ctx.close();
	}

}
