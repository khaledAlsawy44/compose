package com.example.androiddevchallenge.ui.screens.puppies

import com.example.androiddevchallenge.R

inline class PuppyName(val name: String)
inline class PuppyPicture(val url: String)
data class PuppyAge(val age: Int, val ageType: AgeType)

enum class PuppyGender(val gender: String) {
    MALE("Male"), FEMALE("Female")
}

enum class AgeType(val shortCut: String) {
    DAY("Day"), MONTH("Months"), YEAR("Years")
}

inline class OwnerName(val name: String)
inline class OwnerPhone(val phone: String)

data class Puppy(
    val puppyName: PuppyName,
    val puppyPicture: PuppyPicture,
    val puppyAge: PuppyAge,
    val puppyOwner: PuppyOwner,
    val puppyGender: PuppyGender
)

data class PuppyOwner(
    val ownerName: OwnerName,
    val ownerPhone: OwnerPhone
)

data class PuppiesListUiData(
    val isExpanded: Boolean,
    val puppiesList: List<Puppy>
)

sealed class PuppiesState {
    object Loading : PuppiesState()
    data class Default(
        val puppiesData: Map<AgeType, PuppiesListUiData>
    ) : PuppiesState()
}

val dummyData: MutableMap<AgeType, PuppiesListUiData> = mutableMapOf(
    Pair(
        AgeType.YEAR,
        PuppiesListUiData(
            isExpanded = true,
            puppiesList = listOf(
                Puppy(
                    puppyName = PuppyName("Artie"),
                    puppyAge = PuppyAge(2, AgeType.YEAR),
                    puppyGender = PuppyGender.FEMALE,
                    puppyPicture = PuppyPicture(
                        "https://images.unsplash.com/photo-1557584139-4a64373bd2f1?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80"
                    ),
                    puppyOwner = PuppyOwner(
                        ownerName = OwnerName("Ahmed"),
                        ownerPhone = OwnerPhone("+223-56322365")
                    )
                ),
                Puppy(
                    puppyName = PuppyName("Ashley"),
                    puppyAge = PuppyAge(3, AgeType.YEAR),
                    puppyGender = PuppyGender.FEMALE,
                    puppyPicture = PuppyPicture(
                        "https://images.unsplash.com/photo-1422565096762-bdb997a56a84?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80"
                    ),
                    puppyOwner = PuppyOwner(
                        ownerName = OwnerName("Ragy"),
                        ownerPhone = OwnerPhone("+155-5655206620")
                    )
                ),
                Puppy(
                    puppyName = PuppyName("Alvin"),
                    puppyAge = PuppyAge(4, AgeType.YEAR),
                    puppyGender = PuppyGender.FEMALE,
                    puppyPicture = PuppyPicture(
                        "https://images.unsplash.com/photo-1521218597721-2e247daed5db?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1053&q=80"
                    ),
                    puppyOwner = PuppyOwner(
                        ownerName = OwnerName("Noor"),
                        ownerPhone = OwnerPhone("+443-565424120")
                    )
                )
            )
        )
    ),
    Pair(
        AgeType.MONTH,
        PuppiesListUiData(
            isExpanded = true,
            puppiesList = listOf(

                Puppy(
                    puppyName = PuppyName("Aero"),
                    puppyAge = PuppyAge(6, AgeType.MONTH),
                    puppyGender = PuppyGender.FEMALE,
                    puppyPicture = PuppyPicture(
                        "https://images.unsplash.com/photo-1546644719-338fa016d442?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=793&q=80"
                    ),
                    puppyOwner = PuppyOwner(
                        ownerName = OwnerName("John"),
                        ownerPhone = OwnerPhone("+123-56322365")
                    )
                ),
                Puppy(
                    puppyName = PuppyName("Angel"),
                    puppyAge = PuppyAge(2, AgeType.MONTH),
                    puppyGender = PuppyGender.FEMALE,
                    puppyPicture = PuppyPicture(
                        "https://images.unsplash.com/photo-1577380725595-ba33a006c994?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80"
                    ),
                    puppyOwner = PuppyOwner(
                        ownerName = OwnerName("Donia"),
                        ownerPhone = OwnerPhone("+123-565521320")
                    )
                ),
                Puppy(
                    puppyName = PuppyName("Albert"),
                    puppyAge = PuppyAge(4, AgeType.MONTH),
                    puppyGender = PuppyGender.FEMALE,
                    puppyPicture = PuppyPicture(
                        "https://images.unsplash.com/photo-1580306267385-54bb2fafc8b6?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=702&q=80"
                    ),
                    puppyOwner = PuppyOwner(
                        ownerName = OwnerName("Khaled"),
                        ownerPhone = OwnerPhone("+123-565424120")
                    )
                )
            )
        )

    ), Pair(
        AgeType.DAY,
        PuppiesListUiData(
            isExpanded = true,
            puppiesList = listOf(
                Puppy(
                    puppyName = PuppyName("Abby"),
                    puppyAge = PuppyAge(20, AgeType.DAY),
                    puppyGender = PuppyGender.FEMALE,
                    puppyPicture = PuppyPicture("https://images.unsplash.com/photo-1576036668621-a292c88aa53c?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1950&q=80"),
                    puppyOwner = PuppyOwner(
                        ownerName = OwnerName("John"),
                        ownerPhone = OwnerPhone("+123-56322365")
                    )
                ),
                Puppy(
                    puppyName = PuppyName("Abe"),
                    puppyAge = PuppyAge(25, AgeType.DAY),
                    puppyGender = PuppyGender.MALE,
                    puppyPicture = PuppyPicture(
                        "https://images.unsplash.com/photo-1553882809-a4f57e59501d?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=334&q=80"
                    ),
                    puppyOwner = PuppyOwner(
                        ownerName = OwnerName("Jack"),
                        ownerPhone = OwnerPhone("+123-565521320")
                    )
                ),
                Puppy(
                    puppyName = PuppyName("Alexis"),
                    puppyAge = PuppyAge(18, AgeType.DAY),
                    puppyGender = PuppyGender.FEMALE,
                    puppyPicture = PuppyPicture(
                        "https://images.unsplash.com/photo-1601758124277-f0086d5ab050?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=826&q=80"
                    ),
                    puppyOwner = PuppyOwner(
                        ownerName = OwnerName("Khaled"),
                        ownerPhone = OwnerPhone("+123-565424120")
                    )
                )
            )
        )
    )

)

val dummyPets = listOf(
    Pet(
        name = "Dog",
        picture = R.drawable.ic_dog,
        isSelected = true
    ), Pet(
        name = "Cat",
        picture = R.drawable.ic_cat,
        isSelected = false
    ), Pet(
        name = "Rabbit",
        picture = R.drawable.ic_rabbit,
        isSelected = false
    ), Pet(
        name = "Bird",
        picture = R.drawable.ic_bird,
        isSelected = false
    ), Pet(
        name = "Hamster",
        picture = R.drawable.ic_hamster,
        isSelected = false
    )
)

data class Pet(
    val name: String,
    val picture: Int,
    val isSelected: Boolean
)