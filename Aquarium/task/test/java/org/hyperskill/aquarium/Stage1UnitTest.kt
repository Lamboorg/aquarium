package org.hyperskill.aquarium

import android.content.Intent
import org.hyperskill.aquarium.internals.AquariumTest
import org.hyperskill.aquarium.internals.data.AquariumFakeData.fakeListDescriptions
import org.hyperskill.aquarium.internals.data.AquariumFakeData.fakeListImageResources
import org.hyperskill.aquarium.internals.data.AquariumFakeData.fakeListNames
import org.hyperskill.aquarium.internals.screens.PageScreen
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Stage1UnitTest : AquariumTest<MainActivity>(MainActivity::class.java) {

    @Test
    fun test00_checkCardView() {
        testActivity(arguments = stage1Args) {
            PageScreen(this, initViews = false).apply {
                cardView
            }
        }
    }

    @Test
    fun test01_checkNestedScrollView() {
        testActivity(arguments = stage1Args) {
            PageScreen(this, initViews = false).apply {
                nestedScrollView
            }
        }
    }

    @Test
    fun test02_checkImageView() {
        testActivity(arguments = stage1Args) {
            PageScreen(this, initViews = false).apply {
                imageView
            }
        }
    }

    @Test
    fun test03_checkTvName() {
        testActivity(arguments = stage1Args) {
            PageScreen(this, initViews = false).apply {
                tvName
            }
        }
    }

    @Test
    fun test04_checkTvDescription(){
        testActivity(arguments = stage1Args) {
            PageScreen(this, initViews = false).apply {
                tvDescription
            }
        }
    }

    @Test
    fun test05_checkPageDefaultContent(){
        val images = fakeListImageResources.take(1)
        val names = fakeListNames.take(1)
        val descriptions = fakeListDescriptions.take(1)

        testActivity {
            PageScreen(this).apply {
                assertPageTextContent(
                    caseDescription = "When using default content",
                    expectedName = names[0],
                    expectedDescription = descriptions[0]
                )
                assertImageViewResource(R.drawable.image1, "image1")
                assertImageViewScale()
            }
        }
    }

    @Test
    fun test06_checkPageCustomContent(){
        val images = fakeListImageResources.take(2)
        val names = fakeListNames.drop(1)
        val descriptions = fakeListDescriptions.drop(1)

        val args = Intent().apply {
            putExtra("imageAnimals", images as java.io.Serializable)
            putExtra("nameAnimals", names as java.io.Serializable)
            putExtra("descriptionAnimals", descriptions as java.io.Serializable)
        }

        testActivity(arguments = args) {
            PageScreen(this).apply {
                assertPageTextContent(
                    caseDescription = "When using custom content passed through intent.extras",
                    expectedName = names[0],
                    expectedDescription = descriptions[0]
                )
                assertImageViewResource(R.drawable.image1, "image1")
                assertImageViewScale()
            }
        }
    }
}