const TutorDetailsComponent = ({ tutor }) =>{
    return(
        <div>
            {tutor.firstName}
            {tutor.LastName}
            {tutor.mobileNo}
            {tutor.emailId}
            {tutor.totalExperience}
            {tutor.tagline}
            {tutor.summary}
        </div>
    )
}

export default TutorDetailsComponent