Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario Outline: CGI TEST
    Given I navigate to the login page
    And I enter "<username>" and "<password>"
    And I click login button
    Then I navigate to the Annexes Fusionnees page
    Then I add new Annexe with path "<path>"
    Then I navigate to the creation of new folder page
    Then I enter "<Document>"  , "<CharteGraphique>", "<Rédacteurs>" and "<Approbateur>"
    #Then I enter "<DateDeCloture>"
    Then I validate the form1
    Then I navigate to the engagement page
    Then I enter the engagement code : "<engagement code>"
    Then I select the engagement
    #Then I select the CGI
    Then I validate the engagement
    Then I verify that the words was successfully downloaded
  

    Then I navigate to the Annexes Fusionnees page
    Then I delete the annexe added
    Then I close the browser
    Examples:
      | username        | password | Document                    | CharteGraphique       | Rédacteurs    | Approbateur    | path                                                        | engagement code |
      | rgauvin@kpmg.fr | aezan75  | CAC\TEST model base -- test | Modele test           | BELKACEM Amine | BELKACEM Amine | C:\Users\abensalah\.jenkins\workspace\Genedoc_CGI\Test.docx | 2110678         |
     #| rgauvin@kpmg.fr | aezan75  | COVID19\Lettre de mission   | Rapport_CAC_seul.docx | BELKACEM Amine | BELKACEM Amine | /home/ala/PFE/AEZAN/Genedoc/CGIGenedoc/Test.docx            | 1691869         |
