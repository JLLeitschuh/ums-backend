package org.lnu.is.edbo.proxy;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.3
 * 2016-03-08T13:16:11.646+02:00
 * Generated source version: 2.7.3
 * 
 */
@WebService(targetNamespace = "http://edboservice.ua/", name = "EDBOGuidesSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface EDBOGuidesSoap {

    @WebMethod(operationName = "UniversityFacultetSpecialitiesGet", action = "http://edboservice.ua/UniversityFacultetSpecialitiesGet")
    @RequestWrapper(localName = "UniversityFacultetSpecialitiesGet", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.UniversityFacultetSpecialitiesGet")
    @ResponseWrapper(localName = "UniversityFacultetSpecialitiesGetResponse", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.UniversityFacultetSpecialitiesGetResponse")
    @WebResult(name = "UniversityFacultetSpecialitiesGetResult", targetNamespace = "http://edboservice.ua/")
    public org.lnu.is.edbo.proxy.ArrayOfDUniversityFacultetSpecialities universityFacultetSpecialitiesGet(
        @WebParam(name = "SessionGUID", targetNamespace = "http://edboservice.ua/")
        java.lang.String sessionGUID,
        @WebParam(name = "UniversityKode", targetNamespace = "http://edboservice.ua/")
        java.lang.String universityKode,
        @WebParam(name = "UniversityFacultetKode", targetNamespace = "http://edboservice.ua/")
        java.lang.String universityFacultetKode,
        @WebParam(name = "SpecCode", targetNamespace = "http://edboservice.ua/")
        java.lang.String specCode,
        @WebParam(name = "Id_Language", targetNamespace = "http://edboservice.ua/")
        int idLanguage,
        @WebParam(name = "ActualDate", targetNamespace = "http://edboservice.ua/")
        java.lang.String actualDate,
        @WebParam(name = "Id_PersonRequestSeasons", targetNamespace = "http://edboservice.ua/")
        int idPersonRequestSeasons,
        @WebParam(name = "Id_PersonEducationForm", targetNamespace = "http://edboservice.ua/")
        int idPersonEducationForm,
        @WebParam(name = "UniversitySpecialitiesKode", targetNamespace = "http://edboservice.ua/")
        java.lang.String universitySpecialitiesKode,
        @WebParam(name = "SpecDirectionsCode", targetNamespace = "http://edboservice.ua/")
        java.lang.String specDirectionsCode,
        @WebParam(name = "SpecSpecialityCode", targetNamespace = "http://edboservice.ua/")
        java.lang.String specSpecialityCode,
        @WebParam(name = "Filters", targetNamespace = "http://edboservice.ua/")
        java.lang.String filters
    );

    @WebMethod(operationName = "UniversityFacultetSpecialitiesQuotasGet", action = "http://edboservice.ua/UniversityFacultetSpecialitiesQuotasGet")
    @RequestWrapper(localName = "UniversityFacultetSpecialitiesQuotasGet", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.UniversityFacultetSpecialitiesQuotasGet")
    @ResponseWrapper(localName = "UniversityFacultetSpecialitiesQuotasGetResponse", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.UniversityFacultetSpecialitiesQuotasGetResponse")
    @WebResult(name = "UniversityFacultetSpecialitiesQuotasGetResult", targetNamespace = "http://edboservice.ua/")
    public org.lnu.is.edbo.proxy.ArrayOfDUniversityFacultetSpecialitiesQuotas universityFacultetSpecialitiesQuotasGet(
        @WebParam(name = "SessionGUID", targetNamespace = "http://edboservice.ua/")
        java.lang.String sessionGUID,
        @WebParam(name = "Id_Language", targetNamespace = "http://edboservice.ua/")
        int idLanguage,
        @WebParam(name = "ActualDate", targetNamespace = "http://edboservice.ua/")
        java.lang.String actualDate,
        @WebParam(name = "UniversitySpecialitiesKode", targetNamespace = "http://edboservice.ua/")
        java.lang.String universitySpecialitiesKode,
        @WebParam(name = "Id_Quota", targetNamespace = "http://edboservice.ua/")
        int idQuota
    );

    @WebMethod(operationName = "GetLastError", action = "http://edboservice.ua/GetLastError")
    @RequestWrapper(localName = "GetLastError", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.GetLastError")
    @ResponseWrapper(localName = "GetLastErrorResponse", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.GetLastErrorResponse")
    @WebResult(name = "GetLastErrorResult", targetNamespace = "http://edboservice.ua/")
    public org.lnu.is.edbo.proxy.ArrayOfDLastError getLastError(
        @WebParam(name = "GUIDSession", targetNamespace = "http://edboservice.ua/")
        java.lang.String guidSession
    );

    @WebMethod(operationName = "Logout", action = "http://edboservice.ua/Logout")
    @RequestWrapper(localName = "Logout", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.Logout")
    @ResponseWrapper(localName = "LogoutResponse", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.LogoutResponse")
    @WebResult(name = "LogoutResult", targetNamespace = "http://edboservice.ua/")
    public java.lang.String logout(
        @WebParam(name = "SessionGUID", targetNamespace = "http://edboservice.ua/")
        java.lang.String sessionGUID
    );

    @WebMethod(operationName = "LanguagesGet", action = "http://edboservice.ua/LanguagesGet")
    @RequestWrapper(localName = "LanguagesGet", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.LanguagesGet")
    @ResponseWrapper(localName = "LanguagesGetResponse", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.LanguagesGetResponse")
    @WebResult(name = "LanguagesGetResult", targetNamespace = "http://edboservice.ua/")
    public org.lnu.is.edbo.proxy.ArrayOfDLanguages languagesGet(
        @WebParam(name = "SessionGUID", targetNamespace = "http://edboservice.ua/")
        java.lang.String sessionGUID
    );

    @WebMethod(operationName = "UniversityFacultetsGetRequests2", action = "http://edboservice.ua/UniversityFacultetsGetRequests2")
    @RequestWrapper(localName = "UniversityFacultetsGetRequests2", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.UniversityFacultetsGetRequests2")
    @ResponseWrapper(localName = "UniversityFacultetsGetRequests2Response", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.UniversityFacultetsGetRequests2Response")
    @WebResult(name = "UniversityFacultetsGetRequests2Result", targetNamespace = "http://edboservice.ua/")
    public org.lnu.is.edbo.proxy.ArrayOfDUniversityFacultetsRequests2 universityFacultetsGetRequests2(
        @WebParam(name = "SessionGUID", targetNamespace = "http://edboservice.ua/")
        java.lang.String sessionGUID,
        @WebParam(name = "Id_PersonRequestSeasons", targetNamespace = "http://edboservice.ua/")
        int idPersonRequestSeasons,
        @WebParam(name = "UniversityFacultetKode", targetNamespace = "http://edboservice.ua/")
        java.lang.String universityFacultetKode,
        @WebParam(name = "UniversitySpecialitiesKode", targetNamespace = "http://edboservice.ua/")
        java.lang.String universitySpecialitiesKode,
        @WebParam(name = "Id_Language", targetNamespace = "http://edboservice.ua/")
        int idLanguage,
        @WebParam(name = "ActualDate", targetNamespace = "http://edboservice.ua/")
        java.lang.String actualDate,
        @WebParam(name = "PersonCodeU", targetNamespace = "http://edboservice.ua/")
        java.lang.String personCodeU,
        @WebParam(name = "Hundred", targetNamespace = "http://edboservice.ua/")
        int hundred,
        @WebParam(name = "MinDate", targetNamespace = "http://edboservice.ua/")
        java.lang.String minDate,
        @WebParam(name = "Id_PersonRequestStatusType1", targetNamespace = "http://edboservice.ua/")
        int idPersonRequestStatusType1,
        @WebParam(name = "Id_PersonRequestStatusType2", targetNamespace = "http://edboservice.ua/")
        int idPersonRequestStatusType2,
        @WebParam(name = "Id_PersonRequestStatusType3", targetNamespace = "http://edboservice.ua/")
        int idPersonRequestStatusType3,
        @WebParam(name = "Id_PersonEducationForm", targetNamespace = "http://edboservice.ua/")
        int idPersonEducationForm,
        @WebParam(name = "UniversityKode", targetNamespace = "http://edboservice.ua/")
        java.lang.String universityKode,
        @WebParam(name = "Id_Qualification", targetNamespace = "http://edboservice.ua/")
        int idQualification,
        @WebParam(name = "Filters", targetNamespace = "http://edboservice.ua/")
        java.lang.String filters
    );

    @WebMethod(operationName = "SpecSpecializationFind", action = "http://edboservice.ua/SpecSpecializationFind")
    @RequestWrapper(localName = "SpecSpecializationFind", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.SpecSpecializationFind")
    @ResponseWrapper(localName = "SpecSpecializationFindResponse", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.SpecSpecializationFindResponse")
    @WebResult(name = "SpecSpecializationFindResult", targetNamespace = "http://edboservice.ua/")
    public org.lnu.is.edbo.proxy.ArrayOfDSpecSpecialization specSpecializationFind(
        @WebParam(name = "SessionGUID", targetNamespace = "http://edboservice.ua/")
        java.lang.String sessionGUID,
        @WebParam(name = "SpecDirectionsCode", targetNamespace = "http://edboservice.ua/")
        java.lang.String specDirectionsCode,
        @WebParam(name = "SpecSpecialityCode", targetNamespace = "http://edboservice.ua/")
        java.lang.String specSpecialityCode
    );

    @WebMethod(operationName = "UniversitiesGet", action = "http://edboservice.ua/UniversitiesGet")
    @RequestWrapper(localName = "UniversitiesGet", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.UniversitiesGet")
    @ResponseWrapper(localName = "UniversitiesGetResponse", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.UniversitiesGetResponse")
    @WebResult(name = "UniversitiesGetResult", targetNamespace = "http://edboservice.ua/")
    public org.lnu.is.edbo.proxy.ArrayOfDUniversities universitiesGet(
        @WebParam(name = "SessionGUID", targetNamespace = "http://edboservice.ua/")
        java.lang.String sessionGUID,
        @WebParam(name = "UniversityKode", targetNamespace = "http://edboservice.ua/")
        java.lang.String universityKode,
        @WebParam(name = "Id_Language", targetNamespace = "http://edboservice.ua/")
        int idLanguage,
        @WebParam(name = "ActualDate", targetNamespace = "http://edboservice.ua/")
        java.lang.String actualDate,
        @WebParam(name = "UniversityName", targetNamespace = "http://edboservice.ua/")
        java.lang.String universityName
    );

    @WebMethod(operationName = "UniversityFacultetSpecialitiesSubjectsGet2", action = "http://edboservice.ua/UniversityFacultetSpecialitiesSubjectsGet2")
    @RequestWrapper(localName = "UniversityFacultetSpecialitiesSubjectsGet2", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.UniversityFacultetSpecialitiesSubjectsGet2")
    @ResponseWrapper(localName = "UniversityFacultetSpecialitiesSubjectsGet2Response", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.UniversityFacultetSpecialitiesSubjectsGet2Response")
    @WebResult(name = "UniversityFacultetSpecialitiesSubjectsGet2Result", targetNamespace = "http://edboservice.ua/")
    public org.lnu.is.edbo.proxy.ArrayOfDUniversityFacultetSpecialitiesSubjects2 universityFacultetSpecialitiesSubjectsGet2(
        @WebParam(name = "SessionGUID", targetNamespace = "http://edboservice.ua/")
        java.lang.String sessionGUID,
        @WebParam(name = "Id_Language", targetNamespace = "http://edboservice.ua/")
        int idLanguage,
        @WebParam(name = "ActualDate", targetNamespace = "http://edboservice.ua/")
        java.lang.String actualDate,
        @WebParam(name = "UniversitySpecialitiesKode", targetNamespace = "http://edboservice.ua/")
        java.lang.String universitySpecialitiesKode
    );

    /**
     * Підключенння до системи 
     */
    @WebMethod(operationName = "Login", action = "http://edboservice.ua/Login")
    @RequestWrapper(localName = "Login", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.Login")
    @ResponseWrapper(localName = "LoginResponse", targetNamespace = "http://edboservice.ua/", className = "org.lnu.is.edbo.proxy.LoginResponse")
    @WebResult(name = "LoginResult", targetNamespace = "http://edboservice.ua/")
    public java.lang.String login(
        @WebParam(name = "User", targetNamespace = "http://edboservice.ua/")
        java.lang.String user,
        @WebParam(name = "Password", targetNamespace = "http://edboservice.ua/")
        java.lang.String password,
        @WebParam(name = "ClearPreviewSession", targetNamespace = "http://edboservice.ua/")
        int clearPreviewSession,
        @WebParam(name = "ApplicationKey", targetNamespace = "http://edboservice.ua/")
        java.lang.String applicationKey
    );
}