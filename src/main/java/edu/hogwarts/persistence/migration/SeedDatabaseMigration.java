package edu.hogwarts.persistence.migration;

import java.util.Arrays;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import edu.hogwarts.persistence.entity.Course;
import edu.hogwarts.persistence.entity.Course.CourseCategory;
import edu.hogwarts.persistence.entity.CourseMaterial;
import edu.hogwarts.persistence.repository.CourseMaterialRepository;
import edu.hogwarts.persistence.repository.CourseRepository;

public class SeedDatabaseMigration {
	
	
	public static void main(String[] args) {
		
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-core-config.xml");
		
		CourseRepository courseRepository = ctx.getBean(CourseRepository.class);
		CourseMaterialRepository courseMaterialRepository = ctx.getBean(CourseMaterialRepository.class);
		
		/**********************************************************************
		 * Course Materials
		 **********************************************************************/
		CourseMaterial parchment = new CourseMaterial();
		parchment.setName("Parchment");
		parchment.setDescription("Parchment is a writing material made from specially prepared untanned skins of animals—primarily sheep, calves, and goats.");
		parchment.setPrice(2.50);
		parchment.setImageName("parchment.jpg");
		courseMaterialRepository.save(parchment);
		
		CourseMaterial quill = new CourseMaterial();
		quill.setName("Quill and Ink");
		quill.setDescription("A quill pen is a writing implement made from a moulted flight feather (preferably a primary wing-feather) of a large bird. Includes bottle of ink.");
		quill.setPrice(3.00);
		quill.setImageName("quill.jpg");
		courseMaterialRepository.save(quill);
		
		CourseMaterial telescope = new CourseMaterial();
		telescope.setName("Telescope");
		telescope.setDescription("Telescopes are optical instruments that make distant objects appear magnified by using an arrangement of lenses or curved mirrors and lenses, or various devices used to observe distant objects by their emission, absorption, or reflection of electromagnetic radiation.");
		telescope.setPrice(150.00);
		telescope.setImageName("telescope.jpg");
		courseMaterialRepository.save(telescope);
				
		CourseMaterial wand = new CourseMaterial();
		wand.setName("Wand");
		wand.setDescription("A wand is the object through which a witch or wizard channels his or her magic. It is made from wood and has a magical substance at its core. Wands made by Ollivander have cores of phoenix feather, unicorn hair or dragon heartstring, and are of varying woods, lengths, and flexibilities." );
		wand.setPrice(50.00);
		wand.setImageName("wand.png");
		courseMaterialRepository.save(wand);
		
		CourseMaterial robes = new CourseMaterial();
		robes.setName("Plain Black Work Robes (Set of Three)");
		robes.setDescription("Plain work robes are a basic variety of robes. They provide greater defence, agility, magical strength, and magical defence than standard Muggle clothing.[1] Three sets of black plain work robes are required for Hogwarts School of Witchcraft and Wizardry students, as they make up the main constituent of the Hogwarts uniform.");
		robes.setPrice(100.00);
		robes.setImageName("robe.png");
		courseMaterialRepository.save(robes);
		
		CourseMaterial gloves = new CourseMaterial();
		gloves.setName("Protective Gloves");
		gloves.setDescription("Protective gloves are gloves made of dragon hide or other similar materials.[1] They are used to protect one's hands against smelly compost or vicious plants.");
		gloves.setPrice(25.00);
		gloves.setImageName("gloves.png");
		courseMaterialRepository.save(gloves);
		
		CourseMaterial hat = new CourseMaterial();
		hat.setName("Pointed Hat (Black)");
		hat.setDescription("A pointed hat is a type of hat commonly worn by wizardkind. A plain black pointed hat is required to be worn during the day by all Hogwarts School of Witchcraft and Wizardry students as part of the Hogwarts uniform.");
		hat.setPrice(50.00);
		hat.setImageName("hat.jpg");
		courseMaterialRepository.save(hat);
		
		CourseMaterial cloak = new CourseMaterial();
		cloak.setName("One Winter Cloak");
		cloak.setDescription("A winter cloak is a type of cloak designed to keep the wearer warm in cold weather. Compared to plain work robes, a winter cloak provides more defence, magic strength, and magic defence, but substantially less agility (but still more than standard Muggle clothing).[1] Winter cloaks could be purchased at Madam Malkin's Robes for All Occasions[2] for one hundred and fifty Sickles.[1]. A black winter cloak with silver fastenings was required for all Hogwarts School of Witchcraft and Wizardry students, and expected to be worn as part of the school uniform in colder weather.");
		cloak.setPrice(50.00);
		cloak.setImageName("cloak.jpeg");
		courseMaterialRepository.save(cloak);
		
		CourseMaterial cauldron = new CourseMaterial();
		cauldron.setName("Cauldron (pewter, standard size 2)");
		cauldron.setDescription("A cauldron is a vessel similar to a bucket or kettle and is used to brew and hold potions and also may be used to carry supplies. Cauldrons are heated over an open fire and can be hung over a fire from an iron handle.");
		cauldron.setPrice(25.00);
		cauldron.setImageName("cauldron.jpg");
		courseMaterialRepository.save(cauldron);
		
		CourseMaterial darkForcesBook = new CourseMaterial();
		darkForcesBook.setName("The Dark Forces: A Guide to Self-Protection");
		darkForcesBook.setDescription("The Dark Forces: A Guide to Self-Protection is a book authored by Professor Quentin Trimble. This book provides insight and information on various dark creatures, it also contains some defensive spells, such as the Knockback Jinx. ");
		darkForcesBook.setPrice(75.00);
		darkForcesBook.setImageName("dark-forces-book.png");
		courseMaterialRepository.save(darkForcesBook);
		
		CourseMaterial standardSpells = new CourseMaterial();
		standardSpells.setName("The Standard Book of Spells, Grade 1");
		standardSpells.setDescription("The Standard Book of Spells, Grade 1 was the first book in The Standard Book of Spells series, written by Miranda Goshawk. It was a required textbook for first year students at Hogwarts School of Witchcraft and Wizardry.");
		standardSpells.setPrice(75.00);
		standardSpells.setImageName("standardSpells.png");
		courseMaterialRepository.save(standardSpells);
		
		CourseMaterial magicBook = new CourseMaterial();
		magicBook.setName("A History of Magic");
		magicBook.setDescription("A History of Magic was a book written by Bathilda Bagshot, one of the most eminent magical historians to date. It covered the history of the wizarding world up to the end of the 19th century. The contents of the book covered various people and events such as: witch hunts, goblin rebellions, Uric the Oddball, giant wars, and other events as well. This book cost two galleons at Flourish and Blotts.");
		magicBook.setPrice(75.00);
		magicBook.setImageName("magicBook.jpg");
		courseMaterialRepository.save(magicBook);
		
		CourseMaterial beastsBook = new CourseMaterial();
		beastsBook.setName("Fantastic Beasts and Where to Find Them ");
		beastsBook.setDescription("Fantastic Beasts and Where to Find Them is a book written by Newt Scamander detailing magizoology and describing magical creatures. It was a standard textbook at Hogwarts School of Witchcraft and Wizardry since it was written in 1927.");
		beastsBook.setPrice(75.00);
		beastsBook.setImageName("beastsBook.jpg");
		courseMaterialRepository.save(beastsBook);
		
		
		/**********************************************************************
		 *  CORE Courses
		 **********************************************************************/
		Course course = new Course();
		course.setName("Astronomy");
		course.setProfessor("Aurora Sinistra");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Astronomy is a core class and subject taught at Hogwarts School of Witchcraft and Wizardry and Uagadou School of Magic. Astronomy is a branch of magic that studies stars and the movement of planets. It is a subject where the use of practical magic during lessons isn't necessary.");
		course.setCourseMaterials(Arrays.asList(quill, parchment, telescope));
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Defense Against the Dark Arts");
		course.setProfessor("Remus Lupin");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Defense Against the Dark Arts is the class that teaches defensive magic to students so they can protect themselves against the Dark Arts. Often simply referred to as DADA class.\n" + 
				"\n" + 
				"The position of DADA professor was cursed by Tom Riddle when Dumbledore refused to let him teach at Hogwarts. Every professor only held the position for exactly one year, and their tenure ended in some drastic untimely way.");
		course.setCourseMaterials(Arrays.asList(quill, parchment, darkForcesBook));
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Charms");
		course.setProfessor("Filius Flitwick");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Charms is a course that teaches how to cast the class of spells known as Charms. These are spells that alter an object without changing its essential nature. Given a teapot, the spell that makes it tapdance across the desk would be a charm, the spell that turns it into a tortoise would not. This is a core subject, required of all Hogwarts students until at least their fifth year. ");
		course.setCourseMaterials(Arrays.asList(quill, parchment));
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Herbology");
		course.setProfessor("Pomona Sprout");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Herbology is the study of magical and mundane plants and fungi, making it the wizarding equivalent to botany. Herbology is a core class and subject taught at Hogwarts School of Witchcraft and Wizardry and Castelobruxo in which students learn to care for and utilise plants, learn about their magical properties and what they are used for. Many plants provide ingredients for potions and medicine, while others have magical effects of their own right.");
		course.setCourseMaterials(Arrays.asList(quill, parchment));
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Potions");
		course.setProfessor("Severus Snape");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Potions is a core class and subject taught at Hogwarts School of Witchcraft and Wizardry and Ilvermorny School of Witchcraft and Wizardry. In this class, students learn the correct way to brew potions. They follow specific recipes and use various magical ingredients to create the potions, starting with simple ones and moving to more advanced ones as they progress in knowledge. A standard potions kit includes plant ingredients such as Belladonna and supplies such as glass phials and weighing scales.");
		course.setCourseMaterials(Arrays.asList(quill, parchment));
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Transfiguration");
		course.setProfessor("Minerva McGonagall");
		course.setCategory(CourseCategory.CORE);
		course.setDescription("Transfiguration is a branch of magic that focuses on the alteration of the form or appearance of an object, via the alteration of the object's molecular structure. Transfiguration can be done to most (if not all) objects and, as with most forms of magic, it includes — but is hardly limited to — Transfiguration spells.");
		course.setCourseMaterials(Arrays.asList(quill, parchment));
		courseRepository.save(course);
		
		/**********************************************************************
		 *  ELECTIVE Courses
		 **********************************************************************/
		course = new Course();
		course.setName("Alchemy");
		course.setProfessor("Gilderoy Lockhart");
		course.setCategory(CourseCategory.ELECTIVE);
		course.setDescription("Alchemy is an elective course taught at Hogwarts School of Witchcraft and Wizardry. The course is open to sixth and seventh-years if there are enough students interested in taking the subject. The ancient science of Alchemy focuses on the study of nature's four basic elements (fire, earth, air, and water), as well as the transmutation of substances (such as base metals into gold).");
		course.setCourseMaterials(Arrays.asList(quill, parchment));
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Apparition");
		course.setProfessor("Horace Slughorn");
		course.setCategory(CourseCategory.ELECTIVE);
		course.setDescription("Apparition is an optional twelve-week course offered at Hogwarts School of Witchcraft and Wizardry for learning how to Apparate, with the intention of receiving a licence from the age of seventeen.");
		course.setCourseMaterials(Arrays.asList(quill, parchment));
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Care of Magical Creatures");
		course.setProfessor("Rebeus Hagrid");
		course.setCategory(CourseCategory.ELECTIVE);
		course.setDescription("Care of Magical Creatures is an elective course at Hogwarts School of Witchcraft and Wizardry and Ilvermorny School of Witchcraft and Wizardry that can be chosen by students in their third year. In the class, students learn about a wide range of magical creatures, from flobberworms to fire crabs, and even unicorns and thestrals. Students are taught about feeding, maintaining, breeding, and proper treatment of these creatures.");
		course.setCourseMaterials(Arrays.asList(quill, parchment));
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Divination");
		course.setProfessor("Sybill Trelawney");
		course.setCategory(CourseCategory.ELECTIVE);
		course.setDescription("Divination is an elective course taught at Hogwarts School of Witchcraft and Wizardry. It teaches methods of divining the future, or gathering insights into future events, through various rituals and tools. The magic taught in this class, as well as the ability to say prophetic things is a branch of magic referred to as \"Divination.\"");
		course.setCourseMaterials(Arrays.asList(quill, parchment));
		courseRepository.save(course);
		
		/**********************************************************************
		 *  Extra-curricular Courses
		 **********************************************************************/
		
		course = new Course();
		course.setName("Frog Choir");
		course.setProfessor("Filius Flitwick");
		course.setCategory(CourseCategory.EXTRA_CURRICULAR);
		course.setDescription("The Frog Choir was a singing group of Hogwarts students conducted by Professor Filius Flitwick. They usually practised in the Great Hall. The choir is quite talented, being able to both sing fluently in Latin as well as polyphonically.");
		course.setCourseMaterials(Arrays.asList(quill, parchment));
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Magical Theory");
		course.setProfessor("Quirinus Quirrell");
		course.setCategory(CourseCategory.EXTRA_CURRICULAR);
		course.setDescription("Magical Theory is a subject taught at Hogwarts School of Witchcraft and Wizardry, taken at least in the first year. It covers magic from a purely theoretical standpoint, including the topic of how spells work, according to the ad for the book Magical Theory.");
		course.setCourseMaterials(Arrays.asList(quill, parchment));
		courseRepository.save(course);
		
		course = new Course();
		course.setName("Ancient Studies");
		course.setProfessor("Bathsheda Babbling");
		course.setCategory(CourseCategory.EXTRA_CURRICULAR);
		course.setDescription("Ancient Studies is an extra-curricular class taught at Hogwarts School of Witchcraft and Wizardry. The subject presumably focuses on ancient magic, such as the ancient Egyptians' spells. This class is taught in a classroom on the sixth-floor corridor.");
		course.setCourseMaterials(Arrays.asList(quill, parchment));
		courseRepository.save(course);
		
		ctx.close();
	}

}
