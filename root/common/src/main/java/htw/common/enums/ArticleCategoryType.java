package htw.common.enums;

public enum ArticleCategoryType {
	ACCESSORY,
	T_SHIRT, //t-shirt
		TANK_TOP, // debardeur
		POLO, // polo
		T_SHIRT_LONG_SLEEVE, // t-shirt manche longue
		T_SHIRT_SHORT_SLEEVE, // t-shirt manche court
		
	SHIRT, // chemise
		SHIRT_LONG_SLEEVE, // chemise manche longue
		SHIRT_SHORT_SLEEVE, // chemise manche courte
		
	JUMPER_AND_CARDIGAN, // pull et gilet
		JUMPER, // pull
		CARDIGAN, // gilet
		SWEAT_SHIRT, // sweatshirt
		HOODY, // sweat a capuche
		ZIPPED_SWEAT_SHIRT, // sweat a zippe
		FLEECE_JUMPER, // polaire
		
	JACKET, // veste
		WINTER_JACKET, // veste d'hiver
		DOWN_JACKET, // doudoune
		LEATHER_JACKET, // veste en cuir
		LIGHTWEIGHT_JACKET, // veste legere
		BOMBER, // bomber
		DENIM_JACKET, // veste en jean
		GILET, // veste sans manche
		BLAZER, // veste de costume
		
	COAT, // manteau
		PARKA, // parka
		WINTER_COAT, // manteau d'hiver
		SHORT_COAT, // manteau court
		WOOL_COAT, // manteau en laine
		TRENCH, // trench
		
	JEANS, // jeans
		STRAIGHT_LEG, // droit
		SLIM_FIT, // slim
		BOOTCUT, // bootcut
		SKINNY, // skinny
		LOOSE_FIT, // large
	
	TROUSER, // pantalon
		CHINO_TROUSER, // pantalon chino
		CARGO_TROUSER, // pantalon cargo
		JOGGER_AND_SWEAT, // pantalon jogging
		TROUSER_CLASSIC, // pantalon classique
		
	SHORT, // short
		SHORT_AND_BERMUDA, // short et bermudas
		DENIM_SHORT, // Short en jean
		
	SUIT, // costume
		BUSINESS_SHIRT, // chemise "classique"
		TIE, // cravate et accessoire             +--> accessory
		BOWTIE, // papillon                       +--> accessory
		WAISTCOAT, // veste sans manche de costume
		SUIT_JACKET_TROUSER, // costume pantalon + veste
		SUIT_JACKET, // veste de costume
		SUIT_TROUSER, // pantalon de cestume
		CUFFLINK, // Boutons de manchette         +--> accessory
		POCKET_SQUARE, // pochette de costume     +--> accessory
		
	SOCKS,
		SOCKS_SOCKS, // chaussettes
		SPORT_SOCKS, // chaussettes de sport
		KNEE_HIGH_SOCKS, // chaussttes hautes
	
	SHOES,
		BASS_SNEAKERS, // baskets basses
		RISING_SNEAKERS, // baskets mntantes
		SKATE_SHOES, // chaussette de skate
		
	BOOTS,	// bottes
	
	FORMAL_SHOES, // chaussures "classique"
	
	LOAFERS, // mocassins
	
	BOAT_SHOES, // chaussures bateau
	
	SPORT_SHOES, // chaussures de sport
	
	BAG, // sac     							   +--> accessory
		RUCKSACKS, // sac a dos					   +--> accessory
		TRAVEL_BAG, // sac de voyage			   +--> accessory
		SHOULDER_BAF, // sac a bandouliere         +--> accessory
		LAPTOP_BAG, // sac d'ordinateur            +--> accessory
		SPORT_BAG, // sac de sport                 +--> accessory
		SHOPPING_BAG, // cabas                     +--> accessory
		BANANA_BAG, //sac banane                   +--> accessory
		
	SCARF_AND_SHAWL, // echarpe et foulard		   +--> accessory
		SCRAF, // echarpe                          +--> accessory
		SCARF_ROUND, // echarpe rounde			   +--> accessory
		SHAWL, // foulard                          +--> accessory
		
	CAP_AND_BEANIE, // casquette et bonnet         +--> accessory
		CAP, // casquette                          +--> accessory
		BEANIE, // bonnet                          +--> accessory
		HAT, // chapeau                            +--> accessory
		
	GLOVE, // gant								   +--> accessory
	
	WATCH, // montre							   +--> accessory
	
	WALLET, // portfeille                          +--> accessory
	
	BELT, // ceinture							   +--> accessory
	
	SUNGLASSES, // lunette de soleil               +--> accessory
	
	JEWELLERY, // bijoux                           +--> accessory
		BRACELET, // bracelet                      +--> accessory
		NECKLACE, // collier                       +--> accessory
		RING, // bague                             +--> accessory
	
}
